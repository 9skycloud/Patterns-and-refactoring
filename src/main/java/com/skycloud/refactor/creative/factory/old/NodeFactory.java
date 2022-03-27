package com.skycloud.refactor.creative.factory.old;

public class NodeFactory {
	
	protected boolean shouldDecodeNodes = false;
	
	protected boolean shouldRemoveEscapeCharacters = false;
	
	public static Node createStringNode(String textBuffer,boolean shouldDecode) {
		if(shouldDecode)
			return new DecodingStringNode(new StringNode(textBuffer));
		return new StringNode(textBuffer);
	}
	
	public boolean shouldDecodeStringNodes() {
		return shouldDecodeNodes;
	}

	public void setStringNodeDecoding(boolean shouldDecodeNodes) {
		this.shouldDecodeNodes = shouldDecodeNodes;
	}

}
