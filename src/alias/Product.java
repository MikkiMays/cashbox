package alias;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private int category;
    private String articul;
    private int instock;
    private double instockwei;
    private int price;
    private String picture;

    public Product(int id, String name, int category, String articul, int instock, double instockwei, int price, String picture) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.articul = articul;
        this.instock = instock;
        this.instockwei = instockwei;
        this.price = price;
        this.picture = picture;
    }

    public Product(){
        
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    public String getArticul() {
        return articul;
    }

    public int getInstock() {
        return instock;
    }

    public double getInstockwei() {
        return instockwei;
    }

    public int getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public void setInstock(int instock) {
        this.instock = instock;
    }

    public void setInstockwei(double instockwei) {
        this.instockwei = instockwei;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
}
