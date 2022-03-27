package com.skycloud.refactor.html.parser;

import java.net.HttpURLConnection;
import java.net.URL;

import org.htmlparser.Parser;
import org.htmlparser.Remark;
import org.htmlparser.Tag;
import org.htmlparser.Text;
import org.htmlparser.visitors.NodeVisitor;

public class VisitorMain {
	private static String ENCODE = "utf-8";  
	private static void message( String szMsg ) {  
        try{ System.out.println(new String(szMsg.getBytes(ENCODE), System.getProperty("file.encoding"))); }    catch(Exception e ){}  
    }
	
	public static void main(String[] args) {  
	      try{  
	          Parser parser = new Parser( (HttpURLConnection) (new URL("http://127.0.0.1:8080/HTMLParserTester.html")).openConnection() );  
	          NodeVisitor visitor = new NodeVisitor( true, false ) {
//	          NodeVisitor visitor = new NodeVisitor( false, true ) {
//	          NodeVisitor visitor = new NodeVisitor( false, false ) {  
	              public void visitTag(Tag tag) {  
	                 message("This is Tag:"+tag.getText());  
	              }  
	              public void visitStringNode (Text string)    {  
	                   message("This is Text:"+string);  
	              }  
	              public void visitRemarkNode (Remark remark) {  
	                   message("This is Remark:"+remark.getText());  
	              }  
	              public void beginParsing () {  
	                  message("beginParsing");  
	              }  
	              public void visitEndTag (Tag tag){  
	                  message("visitEndTag:"+tag.getText());  
	              }  
	              public void finishedParsing () {  
	                  message("finishedParsing");  
	              }  
	          };  
	  
	          parser.visitAllNodesWith(visitor);  
	      }  
	      catch( Exception e ) {       
	          e.printStackTrace();  
	      }  
	  }
}
