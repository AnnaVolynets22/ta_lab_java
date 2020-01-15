package com.epam.lab.hypermarketoop;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Address address = new Address("Ukraine", "Lviv", "Shevchenka", 15);
        Hypermarket hypermarket = new Hypermarket("MyHypermarket", address);

        Product washbasin1 = new Washbasin("washbasin", 524, ProductType.PLUMBING, "White, 10*5");
        Product bath = new Bath("plumbing2", 10000, ProductType.PLUMBING, "100*5*12");
        Product washbasin2 = new Washbasin("washbasin", 688, ProductType.PLUMBING, "blue, 15");

        ArrayList<Product> products = new ArrayList<>();
        products.add(washbasin1);
        products.add(washbasin2);

        hypermarket.addProduct(bath);

        hypermarket.addProduct(products);

        Product wproduct = new WoodTable("wood", 1500, ProductType.WOOD, "oak");
        hypermarket.addProduct(wproduct);

        Product dproduct = new Paint("decor", 800, ProductType.DECORATIVE, "color:red");
        hypermarket.addProduct(dproduct);

        System.out.println("Plumbing products:");
        hypermarket.getPlumbingProducts().forEach(product -> product.printDetails());

        System.out.println("Wood products:");
        hypermarket.getWoodProducts().forEach(product -> product.printDetails());;

        System.out.println("Decorative products:");
        hypermarket.getDecorativeProducts().forEach(product -> product.printDetails());;

        System.out.println("List of \"washbasin\" products where price <= 1000:");
        hypermarket.find("washbasin", ProductType.PLUMBING, 1000).
                forEach(product -> product.printDetails());;

         Address clientAddress = new Address("Ukraine", "Lviv", "Hirnyka", 1);
         Client client1 = new Client("Ivanov", "Ivan", clientAddress, "ivan@email.com");

         Order order = new Order(products, client1);

         hypermarket.addOrder(order);

         System.out.println("Orders list:");
         hypermarket.getOrdersList().forEach(orderitem -> orderitem.print());

    }
}
