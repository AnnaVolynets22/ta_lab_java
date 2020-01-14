package com.epam.lab.hypermarketoop;

import java.util.ArrayList;
import java.util.Iterator;

public class Hypermarket {
    private String name;
    private Address address;
    private ArrayList<Product> plumbingProducts = new ArrayList<>();
    private ArrayList<Product> woodProducts =  new ArrayList<>();
    private ArrayList<Product> decorativeProducts =  new ArrayList<>();
    private ArrayList<Order> ordersList = new ArrayList<>();

    public void addProduct(Product product) {

        if (product.getType() == ProductType.PLUMBING){
            plumbingProducts.add(product);
        } else if(product.getType() == ProductType.WOOD){
            woodProducts.add(product);
        }else{
            decorativeProducts.add(product);
        }
    }

    public void addProduct(ArrayList<Product> products) {
        Iterator<Product> iter = products.iterator();
        while(iter.hasNext()){
            addProduct(iter.next());
        }
    }

    public ArrayList<Product> getPlumbingProducts() {
        return plumbingProducts;
    }

    public ArrayList<Product> getWoodProducts() {
        return woodProducts;
    }

    public ArrayList<Product> getDecorativeProducts() {
        return decorativeProducts;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }

    public ArrayList<Product> find(String name, String type, int price) {
        ArrayList<Product> productList = new ArrayList<>();

        switch (type){
            case "Plumbing":
                return find(plumbingProducts, name, price);

            case "Wood":
                return find(woodProducts, name, price);

            case "Decorative":
                return find(plumbingProducts, name, price);

            default:
                System.out.println("Sorry. Cannot find product of selected type.");
                return productList;
        }
    }

    private ArrayList<Product> find(ArrayList<Product> products, String name, int price){
        ArrayList<Product> productList = new ArrayList<>();
        Product  product;
        Iterator<Product> iter = products.iterator();

        while(iter.hasNext()){
            product = iter.next();
            if(product.getName().equals(name) && (product.getPrice() <= price)){
                productList.add(product);
            }
        }

        return productList;
    }

}