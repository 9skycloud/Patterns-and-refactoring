package com.skycloud.refactor.creative.builder;


public interface XMLNode {

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.simplify.composed.latest.XmlNode#addValue(java.lang.String)
	 */
	public abstract void addValue(String value);

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.simplify.composed.latest.XmlNode#add(com.skycloud.refactor.simplify.composed.latest.TagNode)
	 */
	public abstract void add(XMLNode node);

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.simplify.composed.latest.XmlNode#addAttributes(java.lang.String, java.lang.String)
	 */
	public abstract void addAttributes(String key, String value);

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.simplify.composed.latest.XmlNode#toXml()
	 */
	public abstract String toXml();

}