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

import java.util.Enumeration;
import java.util.Vector;

import com.skycloud.refactor.visitor.HTMLNode;
import com.skycloud.refactor.visitor.latest.NodeVisitor;

/**
 * Identifies a link tag
 */
public class HTMLLinkTag extends HTMLTag {
	/**
	 * The URL where the link points to
	 */
	protected String link;
	/**
	 * The text of of the link element
	 */
	protected String linkText;
	/**
	 * The contents of link element after the tag added by Kaarle Kaila
	 * 23.10.2001
	 */
	protected String linkContents;
	/**
	 * The accesskey existing inside this link.
	 */
	protected String accessKey;
	private java.util.Vector nodeVector;
	private boolean mailLink;

	/**
	 * Constructor creates an HTMLLinkNode object, which basically stores the
	 * location where the link points to, and the text it contains.
	 * 
	 * @link The URL to which the link points to
	 * @linkText The text which is stored inside this link tag
	 * @linkBegin The beginning position of the link tag
	 * @linkEnd The ending position of the link tag
	 * @param linkContents
	 *            contains the data from the link element
	 * @accessKey The accessKey element of the link tag (valid for Compact HTML
	 *            - IMODE devices)
	 */
	public HTMLLinkTag(String link, String linkText, int linkBegin,
			int linkEnd, String accessKey, String currentLine,
			Vector nodeVector, boolean mailLink, String tagContents,
			String linkContents) {
		super(linkBegin, linkEnd, tagContents, currentLine); // Kaarle Kaila
																// 23.10.2001
		this.link = link;
		this.linkText = linkText;
		this.accessKey = accessKey;
		this.nodeVector = nodeVector;
		this.mailLink = mailLink;
		this.linkContents = linkContents; // Kaarle Kaila 23.10.2001

	}

	/**
	 * Returns the accesskey element if any inside this link tag
	 */
	public String getAccessKey() {
		return accessKey;
	}

	/**
	 * Returns the url as a string, to which this link points
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Returns the text contained inside this link tag
	 */
	public String getLinkText() {
		return linkText;
	}

	/**
	 * Return the text contained in this linkinode Kaarle Kaila 23.10.2001
	 */
	public String getText() {
		return tagContents + ">" + linkContents;
	}

	/**
	 * Insert the method's description here. Creation date: (8/3/2001 1:49:31
	 * AM)
	 * 
	 * @return boolean
	 */
	public boolean isMailLink() {
		return mailLink;
	}

	/**
	 * Insert the method's description here. Creation date: (7/1/2001 4:40:58
	 * PM)
	 */
	public Enumeration linkData() {
		return nodeVector.elements();
	}

	/**
	 * Print the contents of this Link Node
	 */
	public void print() {
		System.out.print("Link to : " + link + "; titled : " + linkText
				+ "; begins at : " + elementBegin() + "; ends at : "
				+ elementEnd() + ", AccessKey=");
		if (accessKey == null)
			System.out.println("null");
		else
			System.out.println(accessKey);
		if (linkData() != null) {
			System.out.println("  " + "LinkData");
			System.out.println("  " + "--------");

			HTMLNode node;
			int i = 0;
			for (Enumeration e = linkData(); e.hasMoreElements();) {
				node = (HTMLNode) e.nextElement();
				System.out.print("   " + (i++) + ":");
				node.print();
			}
		}
	}

	/**
	 * Insert the method's description here. Creation date: (8/3/2001 1:49:31
	 * AM)
	 * 
	 * @param newMailLink
	 *            boolean
	 */
	public void setMailLink(boolean newMailLink) {
		mailLink = newMailLink;
	}

	/**
	 * Insert the method's description here. Creation date: (7/1/2001 4:39:41
	 * PM)
	 * 
	 * @param newNodeVector
	 *            java.util.Vector
	 */
	public void setNodeVector(java.util.Vector newNodeVector) {
		nodeVector = newNodeVector;
	}
	
	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visitLinkTag(this);
	}
	
}
