package com.skycloud.refactor.creative.factory.method.now;

import org.jdom2.Element;

public class DomAdapterBuilder  extends AbstractNode {
	
	public DomAdapterBuilder(String nodeName) {
		super(nodeName);
	}

	public void addSibling(String nodeName){
		addTo(new DomAdapter(((DomAdapter)current).getElement().getParentElement()),nodeName);
	}
	
	public XMLNode findByName(String targetName){
		Element parent = ((DomAdapter)current).getElement();
		while(parent!=null){
			if(parent.getName().equals(targetName)){
				return new DomAdapter(parent);
			}
			parent = parent.getParentElement();
		}
		return null;
	}

	@Override
	public XMLNode createNode(String nodeName) {
		return new DomAdapter(new Element(nodeName));
	}
	

}
