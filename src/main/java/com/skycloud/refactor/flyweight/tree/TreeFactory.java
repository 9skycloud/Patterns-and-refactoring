package com.skycloud.refactor.flyweight.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 设计模式综合解析和重构实战
 * https://ke.qq.com/course/4030688 
 *
 */
public class TreeFactory {
    static List<TreeType> treeTypes = new ArrayList<TreeType>();
 
    static TreeType getTreeType(String name, String color, String texture) {
        TreeType type = null;
        for (TreeType t : treeTypes) {
            if (t.name.equals(name) && t.texture.equals(texture) && t.color.equals(color)) {
                System.out.println("共享池中存在name="+name+"   color="+color+"   texture="+texture);
                type = t;
            }
        }
        if (type == null)
            System.out.println("共享池中不存在name="+name+"   color="+color+"   texture="+texture);
        type = new TreeType(name, color, texture);
        treeTypes.add(type);
        return type;
    }
 
}

