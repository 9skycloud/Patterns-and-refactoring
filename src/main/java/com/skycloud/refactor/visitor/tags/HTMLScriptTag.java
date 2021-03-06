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
 * A HTMLScriptTag represents a JavaScript node
 */
public class HTMLScriptTag extends HTMLTag {
	private java.lang.String language;
	private java.lang.String type;
	/**
	 * The HTMLScriptTag is constructed by providing the beginning posn, ending posn
	 * and the tag contents.
	 * @param tagBegin beginning position of the tag
	 * @param tagEnd ending position of the tag
	 * @param scriptCode The Javascript code b/w the tags
	 * @param language The language parameter
	 * @param type The type parameter
	 * @param tagLine The current line being parsed, where the tag was found	 
	 */
public HTMLScriptTag(int tagBegin, int tagEnd, String scriptCode,String language,String type,String tagLine) 
{
	super(tagBegin,tagEnd,scriptCode,tagLine);
	this.language = language;
	this.type = type;
}
/**
 * Get the language of the script
 * Creation date: (6/4/2001 1:09:34 PM)
 * @return java.lang.String
 */
public java.lang.String getLanguage() {
	return language;
}
/**
 * Get the javascript code in this tag
 * @return java.lang.String
 */
public java.lang.String getScriptCode() {
	return tagContents;
}
/**
 * Insert the method's description here.
 * Creation date: (6/4/2001 1:09:34 PM)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Print the contents of the javascript node
 */
public void print() 
{
	System.out.print("Script Node : ");
	if (language.length()!=0 || type.length()!=0)
	{
		System.out.print("Properties -->");
		if (language.length()!=0) System.out.print("[Language : "+language+"]");
		if (type.length()!=0) System.out.print("[Type : "+type+"]");
	}
	System.out.println();
	System.out.println("Code");
	System.out.println("****");
	System.out.println(tagContents);	
}
/**
 * Set the language of the javascript tag
 * @param newLanguage java.lang.String
 */
public void setLanguage(java.lang.String newLanguage) {
	language = newLanguage;
}
/**
 * Set the type of the javascript node
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
