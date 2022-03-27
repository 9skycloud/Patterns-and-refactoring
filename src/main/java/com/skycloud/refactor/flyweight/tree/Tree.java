package com.skycloud.refactor.flyweight.tree;

import java.awt.Canvas;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */

public class Tree {
    int x,y;
    TreeType type;
     Tree(int x, int y, TreeType type) {
          this.x =x;
          this.y= y;
          this.type = type;
     }
    public void  draw(Canvas canvas) {
        type.draw(canvas, this.x, this.y);
 
    }
}

