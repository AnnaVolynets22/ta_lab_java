package com.epam.lab.hypermarketoop;

public abstract class Product {
    private String name;
    private int price;
    private ProductType type;
    private String description;

    public Product(String name, int price, ProductType type, String description){
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public ProductType getType(){
        return this.type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product: "+ name + " Price: " + price + " Description: " + description;
    }

    public void printDetails(){
        System.out.println(this.toString());
    }
}
