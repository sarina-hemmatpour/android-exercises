package com.example.customlistviewexample;

public class Product {
    private String title;
    private String type;
    private String description;
    private double price;
    private boolean sale;

    public Product(String title,  String description, String type, double price, boolean sale) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.price = price;
        this.sale = sale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
