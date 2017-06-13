package com.example.seven.androidfirstbookalldemo.c3;

/**
 * 用于展示ListView的功能
 * Created by Seven on 2017/5/27.
 * @param name 水果名
 * @param imageId 水果对应图片的资源id
 */

public class C3Fruit {
    private String name;
    private int imageId;

    public C3Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
