package com.skycloud.refactor.visitor;

import com.skycloud.refactor.visitor.latest.NodeVisitor;


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
 * Normal text in the html document is identified and represented by this class.
 */
public class HTMLStringNode implements HTMLNode {
	/**
	 * The text of the string.
	 */
	protected String text;
	/**
	 * The beginning position of the tag in the line
	 */
	protected int textBegin;
	/**
	 * The ending position of the tag in the line
	 */
	protected int textEnd;

	/**
	 * Constructor takes in the text string, beginning and ending posns.
	 * 
	 * @param text
	 *            The contents of the string line
	 * @param textBegin
	 *            The beginning position of the string
	 * @param textEnd
	 *            The ending positiong of the string
	 */
	public HTMLStringNode(String text, int textBegin, int textEnd) {
		this.text = text;
		this.textBegin = textBegin;
		this.textEnd = textEnd;
	}

	/**
	 * Returns the beginning position of the string.
	 */
	public int elementBegin() {
		return textBegin;
	}

	/**
	 * Returns the ending position fo the tag
	 */
	public int elementEnd() {
		return textEnd;
	}

	/**
	 * Locate the remark tag withing the input string, by parsing from the given
	 * position
	 * 
	 * @param reader
	 *            HTML reader to be provided so as to allow reading of next line
	 * @param input
	 *            Input String
	 * @param position
	 *            Position to start parsing from
	 */
	public static HTMLNode find(HTMLReader reader, String input, int position) {
		String text = "";
		int state = 0;
		int textBegin = position;
		int textEnd = position;
		for (int i = position; (i < input.length() && state != 2); i++) {
			// When the input has ended but no text is found, we end up
			// returning null
			if (input.charAt(i) == '<' && state == 0) {
				return null;
			}
			if (input.charAt(i) == '<') {
				state = 2;
				textEnd = i - 1;
			}
			if (state == 0) {
				if (input.charAt(i) != ' ')
					state = 1;
				else
					text += input.charAt(i);
			}
			if (state == 1) {
				text += input.charAt(i);
			}
			if (state == 1 && i == input.length() - 1) {
				state = 2;
				textEnd = i;
			}
		}
		if (textBegin <= textEnd)
			return new HTMLStringNode(text, textBegin, textEnd);
		else
			return null;
	}

	/**
	 * Returns the text of the string line
	 */
	public String getText() {
		return text;
	}

	/**
	 * Print the contents of the string line.
	 */
	public void print() {
		System.out.println("Text = " + text + "; begins at : " + elementBegin()
				+ "; ends at : " + elementEnd());
	}

	public String toString() {
		return "Text = " + text + "; begins at : " + elementBegin()
				+ "; ends at : " + elementEnd();
	}
	
	public void accept(NodeVisitor visitor){
		visitor.visitStringNode(this);
	}
	
}
