package com.iudigital.ea2;


public class Product {
    private String name;
    private double price;
    private int processingTime;

    public Product(String name, double price, int processingTime) {
        this.name = name;
        this.price = price;
        this.processingTime = processingTime;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    
    public int getProcessingTime() {
        return processingTime;
    }

    public void setName(String name) {
        this.name = name;
    }
 
}
