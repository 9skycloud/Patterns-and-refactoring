package com.skycloud.refactor.visitor.latest;

import java.util.Enumeration;

import org.htmlparser.util.ParserException;

import com.skycloud.refactor.decorator.latest.Translate;
import com.skycloud.refactor.visitor.HTMLNode;
import com.skycloud.refactor.visitor.HTMLParser;
import com.skycloud.refactor.visitor.HTMLStringNode;
import com.skycloud.refactor.visitor.tags.HTMLEndTag;
import com.skycloud.refactor.visitor.tags.HTMLLinkTag;
import com.skycloud.refactor.visitor.tags.HTMLTag;

public class TextVisitorExtractor implements NodeVisitor {
	
	private HTMLParser parser;
	
	boolean isPreTag = false;
	boolean isScriptTag = false;
	StringBuffer results = new StringBuffer();

	public TextVisitorExtractor(HTMLParser parser) {
		this.parser = parser;
	}

	public String extractText() throws ParserException{
		HTMLNode node;
		for(Enumeration e = parser.elements();e.hasMoreElements();){
			node = (HTMLNode) e.nextElement();
			node.accept(this);
		}
		return (results.toString());
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.visitor.latest.NodeVisitor#visitHtmlTag(com.skycloud.refactor.visitor.HTMLNode)
	 */
	@Override
	public void visitHtmlTag(HTMLNode node) {
		HTMLTag tag = (HTMLTag) node;
		String tagName = tag.TAGNAME;
		if(tagName.equalsIgnoreCase("PRE"))
			isPreTag = true;
		else if(tagName.equalsIgnoreCase("SCRIPT"))
			isScriptTag = true;
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.visitor.latest.NodeVisitor#visitEndTag(com.skycloud.refactor.visitor.HTMLNode)
	 */
	@Override
	public void visitEndTag(HTMLNode node) {
		HTMLEndTag endTag = (HTMLEndTag) node;
		String tagName = endTag.getContents();
		if(tagName.equalsIgnoreCase("PRE")){
			isPreTag = false;
		}else if(tagName.equalsIgnoreCase("SCRIPT")){
			isScriptTag = false;
		}
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.visitor.latest.NodeVisitor#visitLinkTag(com.skycloud.refactor.visitor.HTMLNode)
	 */
	@Override
	public void visitLinkTag(HTMLNode node) {
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
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.visitor.latest.NodeVisitor#visitStringNode(com.skycloud.refactor.visitor.HTMLNode)
	 */
	@Override
	public void visitStringNode(HTMLNode node) {
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
