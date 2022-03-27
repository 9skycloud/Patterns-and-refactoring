package com.skycloud.refactor.creative.factory.latest;



/**
 * HTML解析器项目 factory 重构后
 * @author QQ445161315
 *
 */
public class StringParser{
	
	Parser parser;
	
	public Node find(){
		String textBuffer = null;
		int textBegin = 0;
		int textEnd = 0;
		NodeFactory factory = new NodeFactory();
		return factory.createStringNode(textBuffer,textBegin,textEnd);
	}
}

class Parser{
	private NodeFactory nodeFactory = new NodeFactory();

	public NodeFactory getNodeFactory() {
		return nodeFactory;
	}

	public void setNodeFactory(NodeFactory nodeFactory) {
		this.nodeFactory = nodeFactory;
	}
}


class StringNode extends Node{

	public StringNode(String textBuffer, int textBegin, int textEnd) {
		
	}
	
}

class DecodingStringNode extends Node{
	StringNode stringNode;
	public DecodingStringNode(StringNode stringNode) {
		this.stringNode = stringNode;
	}
}


class Node {

}