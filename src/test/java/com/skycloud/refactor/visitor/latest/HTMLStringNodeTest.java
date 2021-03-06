package com.skycloud.refactor.visitor.latest;

// HTMLParser Library v1.00 - A java-based parser for HTML
// Copyright (C) Dec 31, 2000 Somik Raha
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
// For any questions or suggestions, you can write to me at :
// Email :somik@kizna.com
// 
// Postal Address : 
// Somik Raha
// R&D Team
// Kizna Corporation
// 2-1-17-6F, Sakamoto Bldg., Moto Azabu, Minato ku, Tokyo, 106 0046, JAPAN

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Enumeration;

import org.htmlparser.util.ParserException;
import org.junit.Test;

import com.skycloud.refactor.visitor.HTMLNode;
import com.skycloud.refactor.visitor.HTMLParser;
import com.skycloud.refactor.visitor.HTMLReader;
import com.skycloud.refactor.visitor.HTMLStringNode;

/**
 * Insert the type's description here. Creation date: (6/17/2001 3:59:52 PM)
 * 
 * @author: Administrator
 */
public class HTMLStringNodeTest {
	/**
	 * HTMLStringNodeTest constructor comment.
	 * 
	 * @param name
	 *            java.lang.String
	 */
	/**
	 * Insert the method's description here. Creation date: (6/4/2001 11:22:36
	 * AM)
	 * 
	 * @return junit.framework.TestSuite
	 */
//	public static TestSuite suite() {
//		TestSuite suite = new TestSuite(HTMLStringNodeTest.class);
//		return suite;
//	}

	/**
	 * The bug being reproduced is this : <BR>
	 * &lt;HTML&gt;&lt;HEAD&gt;&lt;TITLE&gt;Google&lt;/TITLE&gt; <BR>
	 * The above line is incorrectly parsed in that, the text Google is missed.
	 * The presence of this bug is typically when some tag is identified before
	 * the string node is. (usually seen with the end tag). The bug lies in
	 * HTMLReader.readElement(). Creation date: (6/17/2001 4:01:06 PM)
	 */
	@Test
	public void testStringNodeBug1() {
		String testHTML = new String("<HTML><HEAD><TITLE>Google</TITLE>");
		StringReader sr = new StringReader(testHTML);
		HTMLReader reader = new HTMLReader(new BufferedReader(sr), 5000);
		HTMLParser parser = new HTMLParser(reader);
		HTMLNode[] node = new HTMLNode[10];
		int i = 0;
		for (Enumeration e = parser.elements(); e.hasMoreElements();) {
			node[i++] = (HTMLNode) e.nextElement();
		}
		assertEquals("There should be 5 nodes identified", new Integer(5),
				new Integer(i));
		// The fourth node should be a HTMLStringNode- with the text - Google
		assertTrue("Fourth node should be a HTMLStringNode",
				node[3] instanceof HTMLStringNode);
		HTMLStringNode stringNode = (HTMLStringNode) node[3];
		assertEquals("Text of the StringNode", "Google", stringNode.getText());
	}

	/**
	 * Bug reported by Kaarle Kaila of Nokia<br>
	 * For the following HTML : view these documents, you must have &lt;A
	 * href='http://www.adobe.com'&gt;Adobe <br>
	 * Acrobat Reader&lt;/A&gt; installed on your computer.<br>
	 * The first string before the link is not identified, and the space after
	 * the link is also not identified Creation date: (8/2/2001 2:07:32 AM)
	 */
	@Test
	public void testStringNodeBug2() {
		// Register the link scanner

		String testHTML = new String(
				"view these documents, you must have <A href='http://www.adobe.com'>Adobe \n"
						+ "Acrobat Reader</A> installed on your computer.");
		StringReader sr = new StringReader(testHTML);
		HTMLReader reader = new HTMLReader(new BufferedReader(sr), 5000);
		HTMLParser parser = new HTMLParser(reader);
		/*parser.addScanner(new HTMLLinkScanner("-l"));
		HTMLNode[] node = new HTMLNode[10];
		int i = 0;
		for (Enumeration e = parser.elements(); e.hasMoreElements();) {
			node[i++] = (HTMLNode) e.nextElement();
		}
		assertEquals("There should be 3 nodes identified", new Integer(3),
				new Integer(i));
		// The first node should be a HTMLStringNode- with the text - view these
		// documents, you must have
		assertTrue("First node should be a HTMLStringNode",
				node[0] instanceof HTMLStringNode);
		HTMLStringNode stringNode = (HTMLStringNode) node[0];
		assertEquals("Text of the StringNode",
				"view these documents, you must have ", stringNode.getText());
		assertTrue("Second node should be a link node",
				node[1] instanceof HTMLLinkTag);
		HTMLLinkTag linkNode = (HTMLLinkTag) node[1];
		assertEquals("Link is", "http://www.adobe.com", linkNode.getLink());
		assertEquals("Link text is", "Adobe Acrobat Reader",
				linkNode.getLinkText());
		assertTrue("Third node should be a string node",
				node[2] instanceof HTMLStringNode);
		HTMLStringNode stringNode2 = (HTMLStringNode) node[2];
		assertEquals("Contents of third node", " installed on your computer.",
				stringNode2.getText());*/
		
		TextVisitorExtractor extractor = new TextVisitorExtractor(parser);
		try {
			String result = extractor.extractText();
			System.out.println(result);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
}
