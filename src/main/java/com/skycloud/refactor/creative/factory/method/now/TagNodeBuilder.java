package com.skycloud.refactor.creative.factory.method.now;


public class TagNodeBuilder extends AbstractNode {
	
	public TagNodeBuilder(String nodeName) {
		super(nodeName);
	}

	public TagNode findByName(String nodeName){
		TagNode targetNode = (TagNode) current;
		while(targetNode != null){
			if(targetNode.getName().equals(nodeName)){
				return targetNode;
			}
			targetNode = (TagNode) targetNode.getParent();
		}
		return targetNode;
	}
	
	public void addSibling(String nodeName) {
		XMLNode p = current;
		addTo(p,nodeName);
	}

	@Override
	public XMLNode createNode(String nodeName) {
		return new TagNode(nodeName);
	}


}
