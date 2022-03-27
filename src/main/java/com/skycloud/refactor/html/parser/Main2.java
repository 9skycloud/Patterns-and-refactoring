package com.skycloud.refactor.html.parser;

import java.net.HttpURLConnection;
import java.net.URL;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

public class Main2 {
	private static String ENCODE = "utf-8";  
	private static void message( String szMsg ) {  
        try{ System.out.println(new String(szMsg.getBytes(ENCODE), System.getProperty("file.encoding"))); }    catch(Exception e ){}  
    }

	public static void main(String[] args) {  
        
        try{  
            Parser parser = new Parser( (HttpURLConnection) (new URL("http://127.0.0.1:8080/test1.html")).openConnection() );  
          
            // 这里是控制测试的部分，后面的例子修改的就是这个地方。  
            NodeFilter filter = new TagNameFilter ("DIV");  
            NodeList nodes = parser.extractAllNodesThatMatch(filter);   
              
            if(nodes!=null) {  
                for (int i = 0; i < nodes.size(); i++) {  
                    Node textnode = (Node) nodes.elementAt(i);  
                      
                    message("getText:"+textnode.getText());  
                    message("=================================================");  
                }  
            }              
        }  
        catch( Exception e ) {       
            e.printStackTrace();  
        }  
    } 
	
}
