package com.example.arturmusayelyan.jsonexample1;

/**
 * Created by artur.musayelyan on 20/11/2017.
 */

public class ChildrensProduct {
    private String id;
    private String name;
    private String count;
    public ChildrensProduct(){

    }

    public ChildrensProduct(String id, String name, String count) {
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ChildrensProduct{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
