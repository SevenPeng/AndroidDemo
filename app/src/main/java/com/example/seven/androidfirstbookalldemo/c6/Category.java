package com.example.seven.androidfirstbookalldemo.c6;

/**用于LitePal数据库.完成类与表的映射关系
 * Created by Seven on 2017/6/4.
 */
public class Category {
    private int id;
    private String categoryName;
    private int categoryCode;

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
