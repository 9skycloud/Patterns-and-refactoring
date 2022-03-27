package com.skycloud.refactor.simplify.composed.latest;

public interface XmlNode {

	public abstract void addValue(String value);

	public abstract void add(XmlNode node);

	public abstract void addAttributes(String key, String value);

	public abstract String toXml();

}