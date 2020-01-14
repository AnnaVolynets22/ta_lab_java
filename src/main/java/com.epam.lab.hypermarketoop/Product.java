package com.epam.lab.hypermarketoop;

public abstract class Product {
    private String name;
    private int price;
    private ProductType type;

    public Product(String name, int price, ProductType type){
        this.name = name;
        this.price = price;
        this.type = type;
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

    @Override
    public String toString() {
        return "Product: "+ name + " Price: " + price ;
    }

    public void printDetails(){
        System.out.println(this.toString());
    }
}
