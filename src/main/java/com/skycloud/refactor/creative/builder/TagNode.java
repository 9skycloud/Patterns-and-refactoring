package com.skycloud.refactor.creative.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagNode implements XMLNode {
	
	private String name;
	private String value;
	private StringBuffer attributes;
	
	private List<TagNode> children;
	
	private XMLNode parent;
	
	public TagNode(String name) {
		this.name = name;
		if(attributes == null)
			attributes = new StringBuffer();
		if(children ==null)
			children = new ArrayList<TagNode>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public XMLNode getParent() {
		return parent;
	}

	public void setParent(XMLNode parent) {
		this.parent = parent;
	}

	public String getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.simplify.composed.latest.XmlNode#addValue(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.creative.builder.XMLNode#addValue(java.lang.String)
	 */
	@Override
	public void addValue(String value) {
		this.value = value;
	}

	public StringBuffer getAttributes() {
		return attributes;
	}

	public List<TagNode> children() {
		return children;
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.simplify.composed.latest.XmlNode#add(com.skycloud.refactor.simplify.composed.latest.TagNode)
	 */
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.creative.builder.XMLNode#add(com.skycloud.refactor.simplify.composed.latest.XmlNode)
	 */
	@Override
	public void add(XMLNode node) {
		TagNode xnode = (TagNode) node;
		xnode.setParent(this);
		this.children.add(xnode);
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.simplify.composed.latest.XmlNode#addAttributes(java.lang.String, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.creative.builder.XMLNode#addAttributes(java.lang.String, java.lang.String)
	 */
	@Override
	public void addAttributes(String key,String value) {
		attributes.append(" ");
		attributes.append(key+"=\"");
		attributes.append(value);
		attributes.append("\"");
	}
	
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.simplify.composed.latest.XmlNode#toXml()
	 */
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.creative.builder.XMLNode#toXml()
	 */
	@Override
	public String toXml(){
		StringBuffer result = new StringBuffer();
		result.append("<");
		result.append(name);
		result.append(this.attributes);
		if(children.size()>0 || value != null)
			result.append(">");
		else
			result.append("/>");
		if(value != null)
			result.append(value);
		Iterator<TagNode> it = children.iterator();
		while(it.hasNext()){
			XMLNode node = it.next();
			result.append(node.toXml());
		}
		if(children.size()>0 || value != null)
			result.append("</"+name+">");
		return result.toString();
	}
	
	/*public String toXml(){
		StringBuffer result = new StringBuffer();
		result.append("<");
		result.append(name);
		result.append(this.attributes);
		result.append(">");
		result.append(value);
		result.append("</"+name+">");
		return result.toString();
	}*/
	
}
