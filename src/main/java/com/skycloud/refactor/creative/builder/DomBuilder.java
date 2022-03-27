package com.skycloud.refactor.creative.builder;

import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class DomBuilder {
	
	private Element root;
	
	private Element current;

	public DomBuilder(String nodeName) {
		this.root = new Element(nodeName);
		current = root;
	}
	
	public void addAttribute(String key,String value){
		this.current.setAttribute(key, value);
	}
	
	public void addValue(String value){
		this.current.setText(value);
	}
	
	
	public void addChild(String nodeName){
		addTo(current,nodeName);
	}
	
	public void addToTarget(String targetName,String nodeName){
		Element parent = findByName(targetName);
		addTo(parent,nodeName);
	}
	
	public void addSibling(String nodeName){
		addTo(current.getParentElement(),nodeName);
	}
	
	public void addTo(Element node,String nodeName){
		Element child = new Element(nodeName);
		node.addContent(child);
		current = child;
	}
	
	public Element findByName(String targetName){
		Element parent = current;
		while(parent!=null){
			if(parent.getName().equals(targetName)){
				return parent;
			}
			parent = parent.getParentElement();
		}
		return null;
	}
	
	public String printXml(){
		XMLOutputter out = new  XMLOutputter();
		return out.outputString(this.root);
	}

}
