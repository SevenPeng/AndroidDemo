package com.example.seven.androidfirstbookalldemo.c6;

import org.litepal.crud.DataSupport;

/**用于LitePal数据库.完成类与表的映射关系
 * Created by Seven on 2017/6/4.
 */

public class Book extends DataSupport{
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    private String press;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
