package com.skycloud.refactor.creative.factory.method.now;


public abstract class AbstractNode {
	
	private XMLNode root;
	
	protected XMLNode current;
	
	
	public AbstractNode(String nodeName) {
		this.root = createNode(nodeName);
		current = root;
	}
	
	public abstract XMLNode createNode(String nodeName);
	
	public void addTo(XMLNode node,String nodeName){
		XMLNode childNode = createNode(nodeName);
		node.add(childNode);
		current = childNode;
	}
	
	
	public void addChild(String nodeName) {
		addTo(current,nodeName);
	}
	
	
	public void addToTarget(String targetName, String nodeName) {
		XMLNode targetNode = findByName(targetName);
		addTo(targetNode,nodeName);
	}
	
	public abstract XMLNode findByName(String targetName);


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
