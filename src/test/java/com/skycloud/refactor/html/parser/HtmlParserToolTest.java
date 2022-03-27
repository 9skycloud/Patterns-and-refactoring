package com.skycloud.refactor.html.parser;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.skycloud.refactor.html.parser.HtmlParserTool;
import com.skycloud.refactor.html.parser.LinkFilter;

public class HtmlParserToolTest {  
	  
    @Test  
    public void testExtractLinks() {  
        String url = "http://www.baidu.com";  
        LinkFilter linkFilter = new LinkFilter(){  
            @Override  
            public boolean accept(String url) {  
                if(url.contains("baidu")){  
                    return true;  
                }else{  
                    return false;  
                }  
            }  
              
        };  
        Set<String> urlSet = HtmlParserTool.extractLinks(url, linkFilter);  
          
        Iterator<String> it = urlSet.iterator();  
        while(it.hasNext()){  
            System.out.println(it.next());  
        }  
    }  
  
}
