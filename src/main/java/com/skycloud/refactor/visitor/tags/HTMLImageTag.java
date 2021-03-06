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
 * Identifies an image tag 
 */
public class HTMLImageTag extends HTMLTag
{
	/**
	 * The URL where the image is stored.
	 */
	protected String imageURL;
	/**
	 * Constructor creates an HTMLImageNode object, which stores the location
	 * where the image is to be found.
	 * @imageURL location of the image
	 * @imageBegin Beginning position of the image tag
	 * @imageEnd Ending position of the image tag
	 */
	public HTMLImageTag(String imageURL,int imageBegin, int imageEnd,String tagLine)
	{
		super(imageBegin,imageEnd,"",tagLine);
		this.imageURL = imageURL;
	}
	/**
	 * Returns the location of the image
	 */
	public String getImageLocation()
	{
		return imageURL;
	}
	/**
	 * Print the contents of the HTMLImageNode
	 */
	public void print()
	{
		System.out.println("IMAGE TAG : Image at "+imageURL+"; begins at : "+elementBegin()+"; ends at : "+elementEnd());
	}
}
