package com.epam.lab.hypermarketoop;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Product> productsList;
    private Client client;
    private int totalCost;

    public Order(ArrayList<Product> productsList, Client client, int totalCost) {
        orderNumber = hashCode();
        this.productsList = productsList;
        this.client = client;
        this.totalCost = totalCost;
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
}
