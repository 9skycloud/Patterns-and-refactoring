package com.skycloud.refactor.flyweight.tree;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class Forest {
    List<Tree> trees = new ArrayList<Tree>();
 
    public void  plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree  tree = new Tree(x, y, type);
        trees.add(tree);
    }
 
    public void draw(Canvas canvas) {
        for (Tree tree : trees) {
            tree.draw(canvas);
        }
    }
}

