package com.skycloud.refactor.creative.factory.method.now;

import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class DomAdapter implements XMLNode{

	private Element element;

	public DomAdapter(Element element) {
		this.element = element;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	@Override
	public void addValue(String value) {
		element.setText(value);
	}

	@Override
	public void add(XMLNode node) {
		DomAdapter dom = (DomAdapter) node;
		element.addContent(dom.getElement());
	}

	@Override
	public void addAttributes(String key, String value) {
		element.setAttribute(key, value);
	}

	@Override
	public String toXml() {
		XMLOutputter out = new XMLOutputter();
		return out.outputString(this.element);
	}
	
	
}
