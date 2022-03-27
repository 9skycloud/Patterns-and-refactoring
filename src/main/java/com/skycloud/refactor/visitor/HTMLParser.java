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

//////////////////
// Java Imports //
//////////////////
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Vector;

import com.skycloud.refactor.visitor.scanner.HTMLImageScanner;
import com.skycloud.refactor.visitor.scanner.HTMLLinkScanner;
import com.skycloud.refactor.visitor.scanner.HTMLScriptScanner;
import com.skycloud.refactor.visitor.scanner.HTMLStyleScanner;
import com.skycloud.refactor.visitor.scanner.HTMLTagScanner;
import com.skycloud.refactor.visitor.tags.HTMLTag;
import com.skycloud.refactor.visitor.util.HTMLLinkProcessor;
/////////////////////////
// HTML Parser Imports //
/////////////////////////
/**
 * This is the class that the user will use, either to get an iterator into 
 * the html page or to directly parse the page and print the results
 */
public class HTMLParser
{
	/**
	 * The URL or filename to be parsed.
	 */
	protected String resourceLocn;
	/** 
	 * The html reader associated with this parser
	 */
	protected HTMLReader reader;
	/**
	 * The last read HTML node.
	 */
	protected HTMLNode node;
	/**
	 * Keeps track of whether the first reading has been performed.
	 */
	protected boolean readFlag = false;
	private Vector scanners = new Vector();
	public final static java.lang.String VERSION_STRING = "1.00 (Released Jan 5, 2002)";
/**
 * This constructor enables the construction of test cases, with readers
 * associated with test string buffers. 
 * @param reader com.kizna.html.HTMLReader
 */
public HTMLParser(HTMLReader reader) 
{
	this.reader = reader;
	reader.setParser(this);
}
	/**
	 * Creates a HTMLParser object with the location of the resource (URL or file)
	 * @param resourceLocn Either the URL or the filename (autodetects)
	 */
	public HTMLParser(String resourceLocn) 
	{
		this.resourceLocn = resourceLocn;
		openConnection();
	}
/**
 * Add a new Tag Scanner.
 * In typical situations where you require a no-frills parser, use the registerScanners() method to add the most
 * common parsers. But when you wish to either compose a parser with only certain scanners registered, use this method.
 * It is advantageous to register only the scanners you want, in order to achieve faster parsing speed. This method 
 * would also be of use when you have developed custom scanners, and need to register them into the parser.
 * @param scanner HTMLTagScanner object (or derivative) to be added to the list of registered scanners
 */
public void addScanner(HTMLTagScanner scanner) {
	scanners.addElement(scanner);
}
	private String checkEnding(String link)
	{
		// Check if the link ends in html, htm, or /. If not, add a slash
		int l1 = link.indexOf("html");
		int l2 = link.indexOf("htm");
		if (l1==-1 && l2==-1)
		{
			if (link.charAt(link.length()-1)!='/')
			{
				link+="/index.html";
			} 
			return link;
		} else return link;
	}
	/**
	 * Returns an iterator (enumeration) to the html nodes. Each node can be a tag/endtag/
	 * string/link/image<br>
	 * This is perhaps the most important method of this class. In typical situations, you will need to use
	 * the parser like this :
	 * <pre>
	 * HTMLParser parser = new HTMLParser("http://www.yahoo.com");
	 * parser.registerScanners();
	 * for (Enumeration e = parser.elements();e.hasMoreElements();) {
	 *    HTMLNode node = (HTMLNode)e.nextElement();
	 *    if (node instanceof HTMLStringNode) {
	 *        HTMLStringNode stringNode = (HTMLStringNode)node;
	 *        System.out.println(stringNode.getText());
	 *    }
	 * }
	 * </pre>
	 * The above snippet will print out only the text contents in the html document.<br>
	 * Here's another snippet that will only print out the link urls in a document.
	 * <pre>
	 * HTMLParser parser = new HTMLParser("http://www.yahoo.com");
	 * parser.registerScanners();
	 * for (Enumeration e = parser.elements();e.hasMoreElements();) {
	 *    HTMLNode node = (HTMLNode)e.nextElement();
	 *    if (node instanceof HTMLLinkTag) {
	 *        HTMLLinkTag linkTag = (HTMLLinkTag)node;
	 *        System.out.println(linkTag.getLink());
	 *    }
	 * }
	 * </pre>
	 */
	public Enumeration elements()
	{
		return new Enumeration()
		{
			public boolean hasMoreElements()
			{
				if (reader==null) return false;
				try
				{
					node = reader.readElement();
					readFlag=true;
				   if (node==null)
						return false;
					else
						return true;
				}
				catch (IOException e)
				{
					System.err.println("I/O Exception occured while reading "+resourceLocn);
					return false;
				}
			}
			public Object nextElement()
			{
				try
				{
					if (!readFlag) node = reader.readElement();
					return node;
				}
				catch (IOException e)
				{
					System.err.println("I/O Exception occured while reading "+resourceLocn);
					return null;
				}
			}
		};
	}
/**
 * Flush the current scanners registered. The registered scanners list becomes empty with this call.
 */
public void flushScanners() {
	scanners = new Vector();	
}
/**
 * Get the number of scanners registered currently in the scanner.
 * @return int number of scanners registered
 */
public int getNumScanners() {
	return scanners.size();	
}
/**
 * Insert the method's description here.
 * Creation date: (12/24/2001 5:24:20 PM)
 * @return java.util.Vector
 */
public Enumeration getScanners() {
	return scanners.elements();
}
	/*
	 * The main program, which can be executed from the command line
	 */
	public static void main(String [] args)
	{
		System.out.println("HTMLParser v"+VERSION_STRING);
		if (args.length<1 || args[0].equals("-help"))
		{
			System.out.println();
			System.out.println("Syntax : java -jar htmlparser.jar <resourceLocn/website> -l");
			System.out.println("   <resourceLocn> the name of the file to be parsed (with complete path if not in current directory)");
			System.out.println("   -l Show only the link tags extracted from the document");
			System.out.println("   -i Show only the image tags extracted from the document");
			System.out.println("   -s Show only the Javascript code extracted from the document");
			System.out.println("   -t Show only the Style code extracted from the document");
			System.out.println("   -a Show only the Applet tag extracted from the document");
			System.out.println("   -j Parse JSP tags");			
			System.out.println("   -help This screen");
			System.out.println();
			System.out.println("HTML Parser home page : http://htmlparser.sourceforge.net");
			System.out.println();
			System.out.println("Example : java -jar htmlparser.jar http://www.yahoo.com");
			System.out.println();
			System.out.println("If you have any doubts, please join the HTMLParser mailing list (user/developer) from the HTML Parser home page instead of mailing any of the contributors directly. You will be surprised with the quality of open source support. ");
			System.exit(-1);
		}
		if (args[0].indexOf("http")!=-1 || args[0].indexOf("www.")!=-1)
			System.out.println("Parsing website "+args[0]);
		else	
		System.out.println("Parsing file "+args[0]+"...");
		HTMLParser parser = new HTMLParser(args[0]);
		parser.registerScanners();
		if (args.length==2)
		{
			parser.parse(args[1]);
		} else
		parser.parse(null);

	}
	/**
	 * Opens the connection with the resource to begin reading, by creating a HTML reader
	 * object.
	 */
	private void openConnection()
	{
		try
		{
			if (resourceLocn.indexOf("http")!=-1 || resourceLocn.indexOf("www.")!=-1)
			{ 
				// Its a web address
				resourceLocn=HTMLLinkProcessor.removeEscapeCharacters(resourceLocn);
				resourceLocn=checkEnding(resourceLocn);
				URL url = new URL(resourceLocn);
				URLConnection uc = url.openConnection();
				reader = new HTMLReader(new BufferedReader(new InputStreamReader(uc.getInputStream(),"SJIS")),resourceLocn);
			}
			else 
			reader = new HTMLReader(new BufferedReader(new FileReader(resourceLocn)),resourceLocn);
			reader.setParser(this);
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Error! File "+resourceLocn+" not found!");
		}
		catch (MalformedURLException e)
		{
			System.err.println("Error! URL "+resourceLocn+" Malformed!");
		}			
		catch (IOException e)
		{
			System.err.println("I/O Exception occured while reading "+resourceLocn);
		}
	}
	/**
	 * Parse the given resource, using the filter provided
	 */
	public void parse(String filter)
	{
		HTMLNode node;
		for (Enumeration e=elements();e.hasMoreElements();)
		{
			node = (HTMLNode)e.nextElement();
	  	  	if (node!=null)
			{
			 	if (filter==null)
				node.print(); 
				else
				{
					// There is a filter. Find if the associated filter of this node
					// matches the specified filter
					if (!(node instanceof HTMLTag)) continue;
					HTMLTag tag=(HTMLTag)node;
					HTMLTagScanner scanner = tag.getThisScanner();
					if (scanner==null) continue;
					String tagFilter = scanner.getFilter();
					if (tagFilter==null) continue;
					if (tagFilter.equals(filter))
							node.print();
				}		
			}
			else System.out.println("Node is null");
		}

	}
/**
 * This method should be invoked in order to register some common scanners. The scanners that get added are : <br>
 * HTMLLinkScanner   (filter key "-l")<br>
 * HTMLImageScanner  (filter key "-i")<br>
 * HTMLScriptScanner (filter key "-s") <br>
 * HTMLStyleScanner  (filter key "-t") <br>
 * HTMLJspScanner    (filter key "-j") <br>
 * HTMLAppletScanner (filter key "-a") <br>
 * <br>
 * Call this method after creating the HTMLParser object. e.g. <BR>
 * <pre>
 * HTMLParser parser = new HTMLParser("http://www.yahoo.com");
 * parser.registerScanners();
 * </pre>
 */ 
public void registerScanners() {
	if (scanners.size()>0) {
		System.err.println("registerScanners() should be called first, when no other scanner has been registered.");
		System.err.println("Other scanners already exist, hence this method call wont have any effect");
		return;
	}
	addScanner(new HTMLLinkScanner("-l"));
	addScanner(new HTMLImageScanner("-i"));
	addScanner(new HTMLScriptScanner("-s"));
	addScanner(new HTMLStyleScanner("-t"));
}
/**
 * Removes a specified scanner object.
 * @param scanner HTMLTagScanner object to be removed from the list of registered scanners
 */
public boolean removeScanner(HTMLTagScanner scanner) {
	return scanners.removeElement(scanner);
}
/**
 * This method is to be used to change the set of scanners in the current parser.
 * @param newScanners Vector holding scanner objects to be used during the parsing process.
 */
public void setScanners(Vector newScanners) {
	scanners = newScanners;
}
}
