package com.skycloud.refactor.creative.builder;

import com.skycloud.refactor.simplify.composed.latest.TagNode;

public class TagNodeBuilder {
	
	TagNode root;
	
	TagNode current;

	public TagNodeBuilder(String nodeName) {
		this.root = new TagNode(nodeName);
		current = root;
	}
	
	
	public void addTo(TagNode targetNode,String nodeName){
		TagNode node = new TagNode(nodeName);
		targetNode.add(node);
		current = node;
	}
	
	public TagNode findByName(String nodeName){
		TagNode targetNode = (TagNode) current;
		while(targetNode != null){
			if(targetNode.getName().equals(nodeName)){
				return targetNode;
			}
			targetNode = targetNode.getParent();
		}
		return targetNode;
	}
	
	public void addChild(String nodeName) {
		TagNode node = new TagNode(nodeName);
		this.current.add(node);
		current = node;
	}
	
	public void addSibling(String nodeName) {
		TagNode p = current.getParent();
		addTo(p,nodeName);
	}

	public void addToTarget(String targetName, String nodeName) {
		TagNode targetNode = findByName(targetName);
		addTo(targetNode,nodeName);
	}

	public void addAttribute(String key, String val) {
		current.addAttributes(key, val);
	}

	public void addValue(String val) {
		current.addValue(val);
	}

	public String printXml() {
		return root.toXml();
	}

}
