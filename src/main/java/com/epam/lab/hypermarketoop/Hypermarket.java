package com.epam.lab.hypermarketoop;

import java.util.ArrayList;
import java.util.List;

public class Hypermarket {
    private String name;
    private Address address;
    private List<Product> plumbingProducts = new ArrayList<>();
    private List<Product> woodProducts =  new ArrayList<>();
    private List<Product> decorativeProducts =  new ArrayList<>();
    private List<Order> ordersList = new ArrayList<>();

    public Hypermarket(String name, Address address){
        this.name = name;
        this.address = address;
    }

    public List<Product> getPlumbingProducts() {
        return plumbingProducts;
    }

    public List<Product> getWoodProducts() {
        return woodProducts;
    }

    public List<Product> getDecorativeProducts() {
        return decorativeProducts;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void addProduct(Product product) {

        if (product.getType() == ProductType.PLUMBING){
            plumbingProducts.add(product);
        } else if(product.getType() == ProductType.WOOD){
            woodProducts.add(product);
        }else{
            decorativeProducts.add(product);
        }
    }

    public void addProduct(List<Product> products) {
        for (Product product : products) {
            addProduct(product);
        }
    }

    public void addOrder(Order order){
        ordersList.add(order);
    }

    public void addOrder(List<Order> orders){
        ordersList = orders;
    }

    public List<Product> find(String name, ProductType type, int price) {
        List<Product> productList = new ArrayList<>();

        switch (type){
            case PLUMBING:
                productList = find(plumbingProducts, name, price);
                break;
            case WOOD:
                productList = find(woodProducts, name, price);
                break;
            case DECORATIVE:
                productList = find(decorativeProducts, name, price);
                break;
            default:
                System.out.println("Sorry. Cannot find product of selected type.");
        }
        return productList;
    }

    private List<Product> find(List<Product> products, String name, int price){
        List<Product> productList = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().equals(name) && (product.getPrice() <= price)) {
                productList.add(product);
            }
        }

        return productList;
    }

}