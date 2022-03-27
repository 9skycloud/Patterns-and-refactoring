package com.skycloud.refactor.creative.builder;

import com.skycloud.refactor.simplify.composed.latest.TagNode;
import com.skycloud.refactor.simplify.composed.latest.XmlNode;

public class XmlBuilder{
	
	TagNode rootNode;
	
	TagNode currentNode;

	public XmlBuilder(String nodeName) {
		this.rootNode = new TagNode(nodeName);
		currentNode = rootNode;
	}
	
	
	public void addTo(XmlNode targetNode,String nodeName){
		TagNode node = new TagNode(nodeName);
		targetNode.add(node);
		currentNode = node;
	}
	
	public XmlNode findByName(String nodeName){
		TagNode targetNode = currentNode;
		while(targetNode != null){
			if(targetNode.getName().equals(nodeName)){
				return targetNode;
			}
			targetNode = targetNode.getParent();
		}
		return targetNode;
	}
	
	public void addSibling(String nodeName){
		addTo(currentNode.getParent(),nodeName);
	}
	
	public void addChild(String nodeName) {
		addTo(currentNode,nodeName);
	}

	public void addToTarget(String targetName, String nodeName) {
		XmlNode targetNode = findByName(targetName);
		addTo(targetNode,nodeName);
	}

	public void addAttribute(String key, String val) {
		currentNode.addAttributes(key, val);
	}

	public void addValue(String val) {
		currentNode.addValue(val);
	}

	public String printXml() {
		return rootNode.toXml();
	}
	

}
