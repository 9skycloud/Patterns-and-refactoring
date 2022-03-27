package com.skycloud.refactor.simplify.decorator.latest;

import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;

public class Main {

	public static void main(String[] args) {
		try {
			Parser parser=new Parser("<body>这是顶级架构师之路！&nbsp;</body>");
			NodeIterator it = parser.elements();
			while(it.hasMoreNodes()){
				org.htmlparser.Node node = it.nextNode();
				System.out.println(node.toPlainTextString());
				Node no = new DecoratorNode( new StringNode(node.toPlainTextString()));
				System.out.println("装饰后："+no.getText());
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}

}
