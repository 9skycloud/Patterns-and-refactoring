package com.skycloud.refactor.simplify.decorator.old;

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
				StringNode stringNode = new StringNode(node.toPlainTextString());
				System.out.println(node.toPlainTextString());
				System.out.println(stringNode.decode(node.toPlainTextString()));
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}

}
