package com.skycloud.refactor.visitor.old;

import java.util.Enumeration;

import org.htmlparser.util.ParserException;

import com.skycloud.refactor.decorator.latest.Translate;
import com.skycloud.refactor.visitor.HTMLNode;
import com.skycloud.refactor.visitor.HTMLParser;
import com.skycloud.refactor.visitor.HTMLStringNode;
import com.skycloud.refactor.visitor.tags.HTMLEndTag;
import com.skycloud.refactor.visitor.tags.HTMLLinkTag;
import com.skycloud.refactor.visitor.tags.HTMLTag;

public class TextExtractor {
	
	private HTMLParser parser;

	public TextExtractor(HTMLParser parser) {
		this.parser = parser;
	}

	public String extractText() throws ParserException{
		HTMLNode node;
		boolean isPreTag = false;
		boolean isScriptTag = false;
		StringBuffer results = new StringBuffer();
		for(Enumeration e = parser.elements();e.hasMoreElements();){
			node = (HTMLNode) e.nextElement();
			if(node instanceof HTMLStringNode){
				if(!isScriptTag){
					HTMLStringNode stringNode = (HTMLStringNode) node;
					if(isPreTag)
						results.append(stringNode.getText());
					else{
						String text = Translate.decode(stringNode.getText());
						if(getReplaceNonBreakingSpace())
							text = text.replace('\u00a0',' ');
						if(getCollapse())
							collapse(results,text);
						else
							results.append(text);
					}
				}
				
			}else if(node instanceof HTMLLinkTag){
				HTMLLinkTag link = (HTMLLinkTag) node;
				if(isPreTag)
					results.append(link.getLinkText());
				else
					collapse(results,Translate.decode(link.getLinkText()));
				if(link.getLink()!=null){
					results.append("<");
					results.append(link.getLink());
					results.append(">");
				}
			}else if(node instanceof HTMLEndTag){
				HTMLEndTag endTag = (HTMLEndTag) node;
				String tagName = endTag.getContents();
				if(tagName.equalsIgnoreCase("PRE")){
					isPreTag = false;
				}else if(tagName.equalsIgnoreCase("SCRIPT")){
					isScriptTag = false;
				}
			}else if(node instanceof HTMLTag){
				HTMLTag tag = (HTMLTag) node;
				String tagName = tag.TAGNAME;
				if(tagName.equalsIgnoreCase("PRE"))
					isPreTag = true;
				else if(tagName.equalsIgnoreCase("SCRIPT"))
					isScriptTag = true;
			}
		}
		return (results.toString());
	}

	private boolean getLinks() {
		return false;
	}

	private void collapse(StringBuffer results, String text) {
		results.append(text);
	}

	private boolean getCollapse() {
		return false;
	}

	private boolean getReplaceNonBreakingSpace() {
		return false;
	}
	
}
