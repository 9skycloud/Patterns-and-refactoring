package com.skycloud.refactor.creative.builder;

import org.jdom2.Element;

public class DomAdapterBuilder {
	
	private XMLNode root;
	
	private XMLNode current;

	public DomAdapterBuilder(String nodeName) {
		this.root = new DomAdapter(new Element(nodeName));
		current = root;
	}
	
	public void addAttribute(String key,String value){
		DomAdapter node = (DomAdapter) current;
		node.addAttributes(key, value);
	}
	
	public void addValue(String value){
		DomAdapter node = (DomAdapter) current;
		node.addValue(value);
	}
	
	
	public void addChild(String nodeName){
		addTo(current,nodeName);
	}
	
	public void addToTarget(String targetName,String nodeName){
		Element parent = findByName(targetName);
		addTo(new DomAdapter(parent),nodeName);
	}
	
	public void addSibling(String nodeName){
		addTo(new DomAdapter(((DomAdapter)current).getElement().getParentElement()),nodeName);
	}
	
	public void addTo(XMLNode node,String nodeName){
		DomAdapter childNode = new DomAdapter(new Element(nodeName));
		DomAdapter adapter = (DomAdapter) node;
		adapter.add((XMLNode) childNode);
		current = childNode;
	}
	
	public Element findByName(String targetName){
		Element parent = ((DomAdapter)current).getElement();
		while(parent!=null){
			if(parent.getName().equals(targetName)){
				return parent;
			}
			parent = parent.getParentElement();
		}
		return null;
	}
	
	public String printXml(){
		return this.root.toXml();
	}

}
