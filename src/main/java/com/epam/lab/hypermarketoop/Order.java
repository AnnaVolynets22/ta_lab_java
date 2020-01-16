package com.epam.lab.hypermarketoop;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Product> productsList;
    private Client client;
    private int totalCost = 0;

    public Order(ArrayList<Product> productsList, Client client) {
        orderNumber = hashCode();
        this.productsList = productsList;
        this.client = client;
        for(Product product: productsList){
            totalCost += product.getPrice();
        }
    }

    public Order(Product product, Client client) {
        orderNumber = hashCode();
        productsList.add(product);
        this.client = client;
        totalCost = product.getPrice();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public Client getClient() {
        return client;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void print(){
        System.out.println("Order number: " + orderNumber + " Client: " + client.getFirstName() + " "
                + client.getSecondName());
        System.out.println("Order products list: ");
        productsList.forEach(product -> product.printDetails());
    }
}
