package com.skycloud.refactor.visitor.scanner;

import com.skycloud.refactor.visitor.HTMLNode;
import com.skycloud.refactor.visitor.HTMLReader;
import com.skycloud.refactor.visitor.tags.HTMLEndTag;
import com.skycloud.refactor.visitor.tags.HTMLStyleTag;
import com.skycloud.refactor.visitor.tags.HTMLTag;

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

/////////////////////////
// HTML Parser Imports //
/////////////////////////
/**
 * The HTMLStyleScanner scans identifies &lt;style&gt; code
 */

public class HTMLStyleScanner extends HTMLTagScanner {
/**
 * HTMLScriptScanner constructor comment.
 */
public HTMLStyleScanner() {
	super();
}
/**
 * HTMLScriptScanner constructor comment.
 * @param filter java.lang.String
 */
public HTMLStyleScanner(String filter) {
	super(filter);
}
	/**
	 * Template Method, used to decide if this scanner can handle this tag type. If the
	 * evaluation returns true, the calling side makes a call to scan().
	 * @param s The complete text contents of the HTMLTag.
	 */
public boolean evaluate(String s) 
{
	boolean retVal=false;
	// Eat up leading blanks
	s = absorbLeadingBlanks(s);
	// Now, test for the occurence of SCRIPT
	if (s.toUpperCase().indexOf("STYLE")==0) retVal=true;
	return retVal;
}
	/** 
	 * Scan the tag and extract the information related to this type. The url of the 
	 * initiating scan has to be provided in case relative links are found. The initial 
	 * url is then prepended to it to give an absolute link.
	 * The HTMLReader is provided in order to do a lookahead operation. We assume that
	 * the identification has already been performed using the evaluate() method.
	 * @param tag HTML Tag to be scanned for identification
	 * @param url The initiating url of the scan (Where the html page lies)
	 * @param reader The reader object responsible for reading the html page
	 * @param currentLine The current line (automatically provided by HTMLTag)
	 */
public HTMLNode scan(HTMLTag tag, String url, HTMLReader reader,String currentLine) throws java.io.IOException 
{
	// We know we have style stuff. 
	// Parse on till the end tag </style> is found
	String line;
	HTMLEndTag endTag=null;
	HTMLNode node = null;
	boolean endStyleFound=false;
	StringBuffer buff=new StringBuffer();
	// Add the stuff after style to the current list of contents
	int currLoc = currentLine.toUpperCase().indexOf("<STYLE>");
	currLoc += "<STYLE>".length();
	line = currentLine.substring(currLoc,currentLine.length());
	do
	{
		if (line!=null)
		{
			node = HTMLEndTag.find(line,0);
			if (node!=null) 
			{
				HTMLEndTag tempEndTag = (HTMLEndTag)node;
				endTag = new HTMLEndTag(tempEndTag.elementBegin()+tag.elementEnd()+1,tempEndTag.elementEnd()+tag.elementEnd()+1,tempEndTag.getContents());
				if (endTag.getContents().toUpperCase().equals("STYLE")) 
				{
					endStyleFound = true;
					// Append the text prior to the end tag
					String temp = line.substring(0,endTag.elementBegin()-tag.elementBegin());
					buff.append(temp);
				}
				else 
				{
					buff.append(line);
					buff.append("\n\r");
				}
			} 
			else 
			{
				buff.append(line);
				buff.append("\n\r");
			}
			if (!endStyleFound)
			line = reader.getNextLine();			
		}

	}
	while (!endStyleFound && line!=null);
	HTMLStyleTag styleTag = new HTMLStyleTag(tag.elementBegin(),endTag.elementEnd(),buff.toString(),currentLine);
	styleTag.setThisScanner(this);
	return styleTag;
}
}
