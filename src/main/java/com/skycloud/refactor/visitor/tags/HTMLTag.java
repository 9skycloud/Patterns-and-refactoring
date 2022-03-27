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

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

import com.skycloud.refactor.visitor.HTMLNode;
import com.skycloud.refactor.visitor.HTMLReader;
import com.skycloud.refactor.visitor.latest.NodeVisitor;
import com.skycloud.refactor.visitor.scanner.HTMLTagScanner;
/**
 * HTMLTag represents a generic tag. This class allows users to register specific
 * tag scanners, which can identify links, or image references. This tag asks the
 * scanners to run over the text, and identify. It can be used to dynamically 
 * configure a parser.
 */
public class HTMLTag implements HTMLNode
{
    /**
    * Constant used as value for the value of the tag name
    * in parseParameters  (Kaarle Kaila 3.8.2001)
    */
    public final static String TAGNAME = "$<TAGNAME>$";    
	/**
	 * Tag contents will have the contents of the comment tag.
   */
	String tagContents;
	/** 
	 * The beginning position of the tag in the line
	 */		
	int tagBegin;
	/**
	 * The ending position of the tag in the line
	 */	
	int tagEnd;
	/**
	* tag parameters parsed into this hashtable
	* not implemented yet
	* added by Kaarle Kaila 23.10.2001
	*/
	private Hashtable parsed=null;
	
	/**
	 * Scanner associated with this tag (useful for extraction of filtering data from a
	 * HTML node)
	 */
	protected HTMLTagScanner thisScanner=null;
	private java.lang.String tagLine;
	/**
	 * Set the HTMLTag with the beginning posn, ending posn and tag contents
	 * @param tagBegin Beginning position of the tag
	 * @param tagEnd Ending positiong of the tag
	 * @param tagContents The contents of the tag
	 * @param tagLine The current line being parsed, where the tag was found
	 */
	public HTMLTag(int tagBegin, int tagEnd, String tagContents, String tagLine)
	{
		this.tagBegin = tagBegin;
		this.tagEnd = tagEnd;
		this.tagContents = tagContents;
		this.tagLine = tagLine;
	}
  /**
	 * Returns the beginning position of the string.
	 */	
	public int elementBegin()
	{
		return tagBegin;
	}
	/**
	 * Returns the ending position fo the tag
	 */		
	public int elementEnd()
	{
		return tagEnd;
	}
	/**
	 * Locate the tag withing the input string, by parsing from the given position
	 * @param reader HTML reader to be provided so as to allow reading of next line
	 * @param input Input String
	 * @param position Position to start parsing from
	 */			
	public static HTMLTag find(HTMLReader reader,String input,int position)
	{
		int state = 0;
		//String tagContents = "";
		StringBuffer tagContents = new StringBuffer();
		int tagBegin=0;
		int tagEnd=0;
		int i=position;
		int inputLen = input.length();
		char ch;
		while (i<inputLen && state!=2)
		{
			ch = input.charAt(i);
			if (ch=='/' && i>0 && input.charAt(i-1)=='<')
			{
				state = 3;
			}
			if (ch=='>' && state==1)
			{
				state = 2;
				tagEnd = i;
			}				
			if (state==1)
			{
				//tagContents+=input.charAt(i);		
				tagContents.append(ch);
			}
			if (state==3)
			{
				return null;
			}
			if (ch=='<' && (state==0 || state==3))
			{
				// Transition from State 0 to State 1 - Record data till > is encountered
				tagBegin = i;
				state = 1;
			}
			if (state==1 && i==inputLen-1)
			{
				// We need to continue parsing to the next line
				input = reader.getNextLine();
				inputLen = input.length();
				// convert the end of line to a space
				//tagContents+= ' ';
				tagContents.append(' ');
				i=-1;
			}		
			i++;
		}
		if (state==2)
		return new HTMLTag(tagBegin,tagEnd,tagContents.toString(),input);
		else
		return null;	
	}
/*
* in case the tag is parsed at the scan method
* this will return value of a parameter
* not implemented yet
* @param name of parameter
* @author Kaarle Kaila 23.10.2001
*/
	
	public String getParameter(String name){
	    if (parsed == null) return null;
	    return (String)parsed.get(name.toUpperCase());
	}
/*
* in case the tag is parsed at the scan method
* this will return the tag-name (TAG)
* not implemented yet
* @author Kaarle Kaila 23.10.2001
*/
	public String getTag(){
	    if (parsed == null) return null;
	    return (String)parsed.get(TAGNAME);
	}
/**
 * Insert the method's description here.
 * Creation date: (6/6/2001 12:09:38 PM)
 * @return java.lang.String
 */
public java.lang.String getTagLine() {
	return tagLine;
}
	/**
	 * Return the text contained in this tag
	 */
	public String getText()
	{
		return tagContents;
	}
	/**
	 * Return the scanner associated with this tag.
	 */
	public HTMLTagScanner getThisScanner()
	{
		return thisScanner;
	}
	/**
	* Method to break the tag into pieces.
	* @param returns a Hastable with elements containing the
	* pieces of the tag. The tag-name has the value field set to 
	* the constant HTMLTag.TAGNAME. In addition the tag-name is
	* stored into the Hashtable with the name HTMLTag.TAGNAME
	* where the value is the name of the tag.
	* Tag parameters without value
	* has the value "". Parameters with value are represented
	* in the Hastable by a name/value pair.
	* As html is case insensitive but Hastable is not are all
	* names converted into UPPERCASE to the Hastable
	* E.g extract the href values from A-tag's and print them
	* <pre>
	*    
    *    HTMLTag tag;
	*    Hashtable h;
	*    String tmp;
    *    try {
    *        HTMLReader in = new HTMLReader(new FileReader(path),2048);
    *        HTMLParser p = new HTMLParser(in);
    *        Enumeration en = p.elements();
    *        while (en.hasMoreElements()) {
    *            try {
    *                tag = (HTMLTag)en.nextElement();
    *                h = tag.parseParameters();
    *                tmp = (String)h.get(tag.TAGNAME);
    *                if (tmp != null && tmp.equalsIgnoreCase("A")) {;    
    *                    System.out.println("URL is :" + h.get("HREF"));
    *                }
    *            } catch (ClassCastException ce){}
    *        }
    *    }
    *    catch (IOException ie) {
    *        ie.printStackTrace();
    *    }
	* </pre>
	*
	* @author Kaarle Kaila
	* @version 7 AUG 2001
	*/
    public Hashtable parseParameters(){
        Hashtable h = new Hashtable();
        String name,value,t,st;
        final String delim = " \t\r\n\f=\"'>";
        boolean isAmp=false;
        boolean isApo=false;
        boolean isValue=false;
        boolean isName=true;
        boolean waitingForValue = false;
        name=null;
        value=null;
        t=null;
        waitingForValue=false;       
        StringTokenizer token = new StringTokenizer(getText() + " ",delim,true);
        while (token.hasMoreTokens()) {
            st = token.nextToken();
            //
            // First let's combine tokens that are inside "" or ''
            //
            if (isAmp || isApo) {
                if (isAmp && st.equals("\"")){                
                    isAmp= false;                                   
                } else if (isApo && st.equals("'")) {
                    isApo=false;
                }else {               
                    t += st;   
                    continue;
                }
            } else if (st.equals("\"")){                
                isAmp= true;
                t = "";
                continue;
            } else if (st.equals("'")){
                isApo=true;
                t="";
                continue;                
            } else t = st;
            
            // above leaves t with
            // - a delimter
            // - a name of a parameter or the tag itself
            // - a value of a parameter
            if (delim.indexOf(t)>=0) {
                // t was a delimiter
                if (waitingForValue) {
                    if (t.equals("=")) {
                        // here set to receive next value of parameter
                        waitingForValue=false;
                        isValue=true;
                        value="";
                    }
                } 
                if (name != null && isValue==false){
                    if (isName && value == null) value=TAGNAME;
                    else if (value==null) value = ""; // Hastable does not accept nulls
                    if (isName) {
                        // store tagname as tag.TAGNAME,tag                        
                        h.put(value,name.toUpperCase());  
                    } 
                    else {                   
                        // store tag parameters as NAME, value
                        h.put(name.toUpperCase(),value);  
                    }
                    isName=false;
                    name=null;
                    name = null;
                    value=null;
                }                
            }
            else {                
                if (isValue) {
                    value=t;
                    isValue=false;
                }
                else {
                    if (name==null) {
                        name=t;
                        waitingForValue=true;
                    }
                }
            }
        }
        return h;
    }
	/**
	 * Print the contents of the tag
	 */
	public void print()
	{
		System.out.println("Begin Tag : "+tagContents+"; begins at : "+elementBegin()+"; ends at : "+elementEnd());
	}
	/**
	 * Scan the tag to see using the registered scanners, and attempt identification.
	 * @param url URL at which HTML page is located
	 * @param reader The HTMLReader that is to be used for reading the url
	 */
	public HTMLNode scan(Enumeration scanners,String url,HTMLReader reader) throws IOException
	{
		boolean found=false;
		HTMLNode retVal=null;
		
		for (Enumeration e=scanners;(e.hasMoreElements() && !found);)
		{
			HTMLTagScanner scanner = (HTMLTagScanner)e.nextElement();
//			parsed = parseParameters();
	//		if (scanner.evaluate(this))
			if (scanner.evaluate(tagContents))
			{
				found=true;
				retVal=scanner.scan(this,url,reader,tagLine);
			}
		}
		if (!found) return this;
		else {   			
		    return retVal;
		}
	}
    /**
    * Insert the method's description here.
    * Creation date: (6/6/2001 12:09:38 PM)
    * @param newTagLine java.lang.String
    */
    public void setTagLine(java.lang.String newTagLine) {
	    tagLine = newTagLine;
    }
	/**
	 * Set the scanner associated with this tag
	 */
	public void setThisScanner(HTMLTagScanner scanner)
	{
		thisScanner = scanner;
	}
	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visitHtmlTag(this);
	}
	
}
