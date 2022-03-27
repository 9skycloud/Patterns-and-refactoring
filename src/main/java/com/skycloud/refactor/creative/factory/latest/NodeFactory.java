package com.skycloud.refactor.creative.factory.latest;


public class NodeFactory {
	
	protected boolean shouldDecodeNodes = false;

	public boolean isShouldDecodeNodes() {
		return shouldDecodeNodes;
	}

	public void setShouldDecodeNodes(boolean shouldDecodeNodes) {
		this.shouldDecodeNodes = shouldDecodeNodes;
	}

	public Node createStringNode(String textBuffer, int textBegin,
			int textEnd) {
		if(shouldDecodeNodes)
			return new DecodingStringNode(new StringNode(textBuffer,textBegin,textEnd));
		return new StringNode(textBuffer,textBegin,textEnd);
	}
}
