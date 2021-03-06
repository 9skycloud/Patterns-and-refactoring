package com.skycloud.refactor.visitor.tags;

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

/**
 * A HTMLStyleTag represents a &lt;style&gt; tag
 */
public class HTMLStyleTag extends HTMLTag {
	/**
	 * The HTMLStyleTag is constructed by providing the beginning posn, ending posn
	 * and the tag contents.
	 * @param tagBegin beginning position of the tag
	 * @param tagEnd ending position of the tag
	 * @param styleCode The style code b/w the tags
	 * @param tagLine The current line being parsed, where the tag was found	 
	 */
public HTMLStyleTag(int tagBegin, int tagEnd, String styleCode,String tagLine) {
	super(tagBegin,tagEnd,styleCode,tagLine);
}
/**
 * Get the javascript code in this tag
 * @return java.lang.String
 */
public java.lang.String getStyleCode() {
	return tagContents;
}
/**
 * Print the contents of the javascript node
 */
public void print() 
{
	System.out.print("Style Node : ");
	System.out.println();
	System.out.println("Code");
	System.out.println("****");
	System.out.println(tagContents);	
}
}
