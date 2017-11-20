package com.example.arturmusayelyan.jsonexample1;

import java.util.List;

/**
 * Created by artur.musayelyan on 20/11/2017.
 */

public class Product {
    private String id;
    private String name;
    private int count;
    private List<ChildrensProduct> childrensProductList;

    public Product() {

    }

    public Product(String id, String name, int count, List<ChildrensProduct> childrensProductList) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.childrensProductList = childrensProductList;
    }

    public Product(String id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ChildrensProduct> getChildrensProductList() {
        return childrensProductList;
    }

    public void setChildrensProductList(List<ChildrensProduct> childrensProductList) {
        this.childrensProductList = childrensProductList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", childrensProductList=" + childrensProductList +
                '}';
    }

}
