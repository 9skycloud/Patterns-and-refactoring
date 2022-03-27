package com.skycloud.refactor.factory.old;

import org.junit.Test;

import com.skycloud.refactor.creative.factory.old.Node;
import com.skycloud.refactor.creative.factory.old.NodeFactory;
import com.skycloud.refactor.creative.factory.old.Parser;

public class TestFactory {

	@Test
	public void testFactory(){ 
		Parser parser = new Parser();
		NodeFactory factory = new NodeFactory();
		factory.setStringNodeDecoding(true);
		parser.setFactory(factory);
		Node node = parser.parse("In-depth design mode &nbsp; Patterns and refactoring");
		System.out.println(node.getText());
	}
	
}
