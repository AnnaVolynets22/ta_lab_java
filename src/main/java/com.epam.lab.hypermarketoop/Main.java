package com.epam.lab.hypermarketoop;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Hypermarket hypermarket = new Hypermarket();

        Product washbasin1 = new Washbasin("washbasin", 524, ProductType.PLUMBING);
        Product bath = new Bath("plumbing2", 10000, ProductType.PLUMBING);
        Product washbasin2 = new Washbasin("washbasin", 688, ProductType.PLUMBING);

        ArrayList<Product> products = new ArrayList<>();
        products.add(washbasin1);
        products.add(washbasin2);

        hypermarket.addProduct(bath);

        hypermarket.addProduct(products);

        Product wproduct = new WoodTable("wood", 1500, ProductType.WOOD);
        hypermarket.addProduct(wproduct);

        Product dproduct = new Paint("decor", 800, ProductType.DECORATIVE);
        hypermarket.addProduct(dproduct);

        hypermarket.getPlumbingProducts().forEach(product -> product.printDetails());
        hypermarket.getWoodProducts().forEach(product -> product.printDetails());;
        hypermarket.getDecorativeProducts().forEach(product -> product.printDetails());;

        hypermarket.find("washbasin", "Plumbing", 1000).
                forEach(product -> product.printDetails());;

    }
}
