package com.skycloud.refactor.flyweight.tree;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class TreeType {
    public String name;
    public String color;
    public String texture;
 
    TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }
 
    public void draw(Canvas canvas, int x, int y) {
        // 1. 创建特定类型、颜色和纹理的位图。
        // 2. 在画布坐标 (X,Y) 处绘制位图。
    	Frame f = new Frame("绘制森林");
    	f.add(canvas);
    	f.setLayout(null);
    	f.setSize(500, 400);
    	f.setVisible(true);
    }
    
    public static void tree(double x1,double y1,double x2,double y2,int n,Graphics g) 
	{ 
	        if(n>=1)
	        {    
	        	double x3,x4,y3,y4; 
	        	g.drawLine((int)(x1),(int)(y1),(int)(x2),(int)(y2));	
	        	x3=(x1+x2)/2; 
	        	y3=(y1+y2)/2; 
	        	tree(x1,y1,x3,y3,n-1,g); 
	        	tree(x3,y3,x2,y2,n-1,g); 
	        	
	        	x4=(x2+y2-y3-x3)*0.7071+x3; 
	        	y4=(y2-x2+x3-y3)*0.7071+y3; 
	        	tree(x3,y3,x4,y4,n-1,g);        	
	        	x3=(x1*3+x2)/4; 
	        	y3=(y1*3+y2)/4; 
	        	
	        	x2=(x2*3+x1)/4; 
	        	y2=(y2*3+y1)/4; 
	        	x4=(x2*1.732-y2+2*x3-x3*1.732+y3)/2; 
	        	y4=(x2+y2*1.732-x3+2*y3-1.732*y3)/2; 
	        	tree(x3,y3,x4,y4,n-1,g); 	
	        } 
	}
    
    public static void main(String[] args) {
    	Frame f = new Frame("绘制森林");
//    	f.add(canvas);
//    	f.setLayout(null);
//    	f.setSize(500, 400);
//    	
//    	Graphics g = new Graphics();
//		tree(200.0,400.0,200.0,0.0,7,g); 
	}
 
 
}

