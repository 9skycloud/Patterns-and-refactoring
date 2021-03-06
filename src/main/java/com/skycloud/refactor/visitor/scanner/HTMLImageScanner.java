package com.skycloud.refactor.visitor.scanner;

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

//////////////////
// Java Imports //
//////////////////
import java.io.IOException;
import java.util.Hashtable;

import com.skycloud.refactor.visitor.HTMLNode;
import com.skycloud.refactor.visitor.HTMLReader;
import com.skycloud.refactor.visitor.tags.HTMLImageTag;
import com.skycloud.refactor.visitor.tags.HTMLTag;
import com.skycloud.refactor.visitor.util.HTMLLinkProcessor;
/////////////////////////
// HTML Parser Imports //
/////////////////////////
/**
 * Scans for the Image Tag. This is a subclass of HTMLTagScanner, and is called using a 
 * variant of the template method. If the evaluate() method returns true, that means the
 * given string contains an image tag. Extraction is done by the scan method thereafter
 * by the user of this class.
 */
public class HTMLImageScanner extends HTMLTagScanner
{
	/**
	 * Overriding the default constructor
	 */
	public HTMLImageScanner()
	{
		super();
	}
	/**
	 * Overriding the constructor to accept the filter 
	 */	
	public HTMLImageScanner(String filter)
	{
		super(filter);
	}
	/**
	 * Template Method, used to decide if this scanner can handle the Image tag type. If 
	 * the evaluation returns true, the calling side makes a call to scan().
	 * @param s The complete text contents of the HTMLTag.
	 */
	public boolean evaluate(String s)
	{
		// Eat up leading blanks
		s = absorbLeadingBlanks(s);		
		int state = 0;
		s=s.toUpperCase();
		for (int i=0;(i<s.length() && state<3);i++)
		{
			char ch = s.charAt(i);
			if (ch=='I' && state==0) 
			{
				state=1; 
				continue;
			}
			if (ch=='M' && state==1)
			{
				state=2;
				continue;
			}
			if (ch=='G' && state==2)
			{
				state=3;
				continue;
			}
			if (ch==' ') continue;
			state=4;
		}
		if (state==3) return true; else return false;
	}
  /**
   * Extract the location of the image, given the string to be parsed, and the url
   * of the html page in which this tag exists.
   * @param s String to be parsed
   * @param url URL of web page being parsed
   */
	public String extractImageLocn(HTMLTag tag,String url)
	{
		Hashtable table = tag.parseParameters();
		String relativeLink =  (String)table.get("SRC");
		if (relativeLink==null) return ""; else
		return (new HTMLLinkProcessor()).extract(relativeLink,url);		
	}
	/** 
	 * Scan the tag and extract the information related to the <IMG> tag. The url of the 
	 * initiating scan has to be provided in case relative links are found. The initial 
	 * url is then prepended to it to give an absolute link.
	 * The HTMLReader is provided in order to do a lookahead operation. We assume that
	 * the identification has already been performed using the evaluate() method.
	 * @param tag HTML Tag to be scanned for identification
	 * @param url The initiating url of the scan (Where the html page lies)
	 * @param reader The reader object responsible for reading the html page
	 * @param currentLine The current line (automatically provided by HTMLTag)	 
	 */	
	public HTMLNode scan(HTMLTag tag,String url,HTMLReader reader,String currentLine) throws IOException
	{
		HTMLNode node;
		String link,linkText="";
		int linkBegin, linkEnd;

		// Yes, the tag is a link
		// Extract the link
		//link = extractImageLocn(tag.getText(),url);
		link = extractImageLocn(tag,url);
		linkBegin = tag.elementBegin();
		linkEnd = tag.elementEnd();
		HTMLImageTag imageTag = new HTMLImageTag(link,linkBegin,linkEnd,currentLine);
		imageTag.setThisScanner(this);
		return imageTag;
	}
}
