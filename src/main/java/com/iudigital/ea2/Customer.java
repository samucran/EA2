package com.iudigital.ea2;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Product> shoppingCart;

    public Customer() {
        shoppingCart = new ArrayList<>();
        initializeShoppingCart();
    }
    
    private void initializeShoppingCart() {
        shoppingCart.add(new Product("Arroz", 2.5,3));
        shoppingCart.add(new Product("Frijoles", 1.8,2));
        shoppingCart.add(new Product("Leche", 1.0,2));
        shoppingCart.add(new Product("Pan", 1.2,2));
        //agregar mas productos según sea necesario
    }

    public void addToCart(Product product) {
        shoppingCart.add(product);
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }
}
