package com.skycloud.refactor.visitor;

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
//
// Improvements contributed by Nash Tsai (nash_c@users.sourceforge.net)
// Bug fixes contributed by Kaarle Kaila (kaila@users.sourceforge.net)
//
//////////////////
// Java Imports //
//////////////////
import java.io.BufferedReader;
import java.io.IOException;
/////////////////////////
// HTML Parser Imports //
/////////////////////////



import com.skycloud.refactor.visitor.tags.HTMLEndTag;
import com.skycloud.refactor.visitor.tags.HTMLTag;

/**
 * HTMLReader builds on the BufferedReader, providing methods to read one element
 * at a time
 */
public class HTMLReader extends BufferedReader
{
	protected int posInLine=-1;
	protected String line;
	protected HTMLNode node = null;
	protected String url;
	private java.io.BufferedReader in;
	private HTMLParser parser;
	/**
	 * This constructor basically overrides the existing constructor in the
	 * BufferedReader class.
	 */

	public HTMLReader(BufferedReader in, int len)
	{
		super(in,len);
		this.in = in;
		this.parser = null;
	}
	/**
	 * The constructor takes in a reader object, and the url to be read.
	 */
	public HTMLReader(BufferedReader in,String url)
	{
		super(in);
		this.in = in;
		this.url = url;
		this.parser = null;		
	}
/**
 * This method is useful when designing your own scanners. You might need to find out what is the location where the
 * reader has stopped last.
 * @return int Last position read by the reader
 */
public int getLastReadPosition() {
	if (node!=null) return node.elementEnd(); else
	return 0;
}
	/*
	 * Read the next line
	 * @return String containing the line
	 */
	public String getNextLine()
	{
		try
		{
			line = readLine();
			posInLine = 0;
			return line;
		}
		catch (IOException e)
		{
			System.err.println("I/O Exception occurred while reading!");
		}
		return null;
	}
/**
 * Insert the method's description here.
 * Creation date: (12/24/2001 5:27:37 PM)
 * @return com.kizna.html.HTMLParser
 */
public HTMLParser getParser() {
	return parser;
}
	/**
	 * Read the next element
	 * @return HTMLNode - The next node
 	 */
	public HTMLNode readElement() throws IOException
	{
		if (readNextLine())
		{
			do
			{
				line = getNextLine();
			}
			while (line!=null && line.length()==0);

		} else
		posInLine=node.elementEnd()+1;
		if (line==null) return null;
		node = HTMLRemarkNode.find(this,line,posInLine);
		if (node!=null) return node;

		node = HTMLStringNode.find(this,line,posInLine);
		if (node!=null) return node;
		
		node = HTMLTag.find(this,line,posInLine);
		if (node!=null)
		{
			HTMLTag tag = (HTMLTag)node;
			try
			{
				node = tag.scan(parser.getScanners(),url,this);
				return node;
			}
			catch (IOException e)
			{
				System.err.println("Error! I/O Exception occurred while reading "+url);
			}
		}

		// If we couldnt get a string, then it is probably an end tag
		
		node = HTMLEndTag.find(line,posInLine);
		if (node!=null) return node;

	
		return null;
	}
/**
 * Delegates to the BufferedReader's readLine method
 * @return String line read by the reader
 */
public String readLine() throws IOException{
	return in.readLine();
}
	/**
	 * Do we need to read the next line ?
	 * @return true - yes/ false - no
	 */
	protected boolean readNextLine()
	{
		if (posInLine==-1 || (line!=null && node.elementEnd()+1>=line.length()))
				return true;
		else return false;
	}
/**
 * The setParser method is used by the parser to put its own object into the reader. This happens internally,
 * so this method is not generally for use by the developer or the user.
 */
public void setParser(HTMLParser newParser) {
	parser = newParser;
}
}
