package com.skycloud.refactor.html.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.htmlparser.Parser;
import org.htmlparser.visitors.TextExtractingVisitor;
  
/** 
* @author www.baizeju.com 
*/  
public class Main {  
    private static String ENCODE = "GBK";  
    private static void message( String szMsg ) {  
        try{System.out.println(new String(szMsg.getBytes(ENCODE), System.getProperty("file.encoding"))); } catch(Exception e ){}  
    }  
    public static String openFile( String szFileName ) {  
        try {  
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream( new File(szFileName)), ENCODE) );  
            String szContent="";  
            String szTemp;  
              
            while ( (szTemp = bis.readLine()) != null) {  
                szContent+=szTemp+"\n";  
            }  
            bis.close();  
            return szContent;  
        }  
        catch( Exception e ) {  
            return "";  
        }  
    }  
      
   public static void main(String[] args) {  
          
        String szContent = openFile( "E:/My Sites/HTMLParserTester.html");  
          
        try{  
            //Parser parser = Parser.createParser(szContent, ENCODE);  
            //Parser parser = new Parser( szContent );  
           Parser parser = new Parser( (HttpURLConnection) (new URL("https://www.baidu.com/")).openConnection() );  
          
            TextExtractingVisitor visitor = new TextExtractingVisitor();  
            parser.visitAllNodesWith(visitor);  
            String textInPage = visitor.getExtractedText();  
  
            message(textInPage);  
        }  
        catch( Exception e ) {              
        }  
    }  
} 
