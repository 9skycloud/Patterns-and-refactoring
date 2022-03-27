package com.skycloud.refactor.visitor.scanner;

import com.skycloud.refactor.visitor.HTMLNode;
import com.skycloud.refactor.visitor.HTMLReader;
import com.skycloud.refactor.visitor.tags.HTMLDoctypeTag;
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

public class HTMLDoctypeScanner extends HTMLTagScanner {
	private java.lang.String language;
	private java.lang.String type;
/**
 * HTMLScriptScanner constructor comment.
 */
public HTMLDoctypeScanner() {
	super();
}
/**
 * HTMLScriptScanner constructor comment.
 * @param filter java.lang.String
 */
public HTMLDoctypeScanner(String filter) {
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
	// Now, test for the occurence of the JSP/ASP tag
	// If its a JSP tag, it will begin and end with %
	if (s.toUpperCase().indexOf("!DOCTYPE")==0) retVal = true;
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
	// Find the JSP Tag - basically remove the first and last character
	String tagContents = tag.getText();
	// Cut from 9th char -- a space after !DOCTYPE _
	tagContents=tagContents.substring(9,tagContents.length());
	HTMLDoctypeTag docTypeTag = new HTMLDoctypeTag(tag.elementBegin(),tag.elementEnd(),tagContents,currentLine);
	docTypeTag.setThisScanner(this);
	return docTypeTag;

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
