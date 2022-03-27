package com.skycloud.refactor.flyweight.tree;

import java.awt.Canvas;
import java.awt.Color;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Main {

	public static void main(String[] args) {
		Forest forest = new Forest();
        forest.plantTree(1,2,"a","red","大理石");
        forest.plantTree(1,3,"b","red","大理石");
        forest.plantTree(1,4,"b","red","大理石");
        
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.GRAY);
        canvas.setSize(500, 400);
        forest.draw(canvas);
	}
}

