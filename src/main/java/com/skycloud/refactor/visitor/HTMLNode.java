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
 * A HTMLNode interface is implemented by all types of nodes (tags, string elements, etc)
 */
public interface HTMLNode
{
	/**
	 * Return the beginning position of the element
	 */
	public int elementBegin();
	/**
	 * Return the ending position of the element
	 */
	public int elementEnd();
	/**
	 * Print the contents of the html node
	 */
	public void print();
	
	
	public void accept(NodeVisitor visitor);
	
}
