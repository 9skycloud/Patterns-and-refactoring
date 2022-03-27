package com.skycloud.refactor.visitor.scanner;

import com.skycloud.refactor.visitor.HTMLNode;
import com.skycloud.refactor.visitor.HTMLReader;
import com.skycloud.refactor.visitor.tags.HTMLEndTag;
import com.skycloud.refactor.visitor.tags.HTMLScriptTag;
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
 * The HTMLScriptScanner scans identifies javascript code
 */

public class HTMLScriptScanner extends HTMLTagScanner {
	private java.lang.String language;
	private java.lang.String type;
/**
 * HTMLScriptScanner constructor comment.
 */
public HTMLScriptScanner() {
	super();
}
/**
 * HTMLScriptScanner constructor comment.
 * @param filter java.lang.String
 */
public HTMLScriptScanner(String filter) {
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
	if (s.toUpperCase().indexOf("SCRIPT")==0) retVal=true;
	return retVal;
}
/**
 * Insert the method's description here.
 * Creation date: (6/4/2001 11:30:03 AM)
 * @param tag com.kizna.html.HTMLTag
 */
public void extractLanguage(HTMLTag tag) 
{
	language = extractField(tag,"LANGUAGE");
}
/**
 * Insert the method's description here.
 * Creation date: (6/4/2001 12:12:20 PM)
 */
public void extractType(HTMLTag tag) 
{
	type = extractField(tag,"TYPE");
}
/**
 * Insert the method's description here.
 * Creation date: (6/4/2001 11:55:32 AM)
 * @return java.lang.String
 */
public java.lang.String getLanguage() {
	return language;
}
/**
 * Insert the method's description here.
 * Creation date: (6/4/2001 12:20:57 PM)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
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
	// We know we have script stuff. So first extract the information from the tag about the language
	extractLanguage(tag);
	extractType(tag);
	// Parse on till the end tag </script> is found
	String line;
	HTMLEndTag endTag=null;
	HTMLNode node = null;
	boolean endScriptFound=false;
	StringBuffer buff=new StringBuffer();
	// Take the line after the current tag
	line = currentLine;
	// Set the looking positiong for endTag to just after the begin tag
	int lookPos = tag.elementEnd()+1;
	do
	{	
		if (line!=null)
		{
			node = HTMLEndTag.find(line,lookPos);
			if (node!=null) 
			{
				endTag = (HTMLEndTag)node;
				if (endTag.getContents().toUpperCase().equals("SCRIPT")) 
				{
					endScriptFound = true;
					// Check if there was anything in front of endTag, and if so, add it to the code buffer
					if (endTag.elementBegin()>0)
					{
						buff.append(line.substring(lookPos,endTag.elementBegin()));	
					}
				}else 
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
			
		}
		if (!endScriptFound) 
		{
			line = reader.getNextLine();
			// Set the looking position for the end tag to 0
			lookPos = 0;
		}
	}
	while (!endScriptFound && line!=null);
	HTMLScriptTag scriptTag = new HTMLScriptTag(0,node.elementEnd(),buff.toString(),language,type,currentLine);
	scriptTag.setThisScanner(this);
	return scriptTag;
}
/**
 * Insert the method's description here.
 * Creation date: (6/4/2001 11:55:32 AM)
 * @param newLanguage java.lang.String
 */
public void setLanguage(java.lang.String newLanguage) {
	language = newLanguage;
}
/**
 * Insert the method's description here.
 * Creation date: (6/4/2001 12:20:57 PM)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
