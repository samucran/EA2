package com.iudigital.ea2;

import java.util.concurrent.TimeUnit;


public class Cashier {
    private String name;
    private boolean noMoreCustomers;

    public Cashier(String name) {
        this.name = name;
    }

    public void processPurchase(Customer customer) {
        //logica para procesar la compra y calcular tiempos
        while (!noMoreCustomers) {
            if (customer != null) {
                System.out.println(name + " esta procesando la compra del cliente.");
                double totalCost = 0.0;

                for (Product product : customer.getShoppingCart()) {
                    double productCost = processProduct(product);
                    totalCost += productCost;

                    //mostrar informacion sobre el producto
                    System.out.println("Producto: " + product.getName() +
                                       ", Precio: " + product.getPrice() +
                                       ", Costo Total: " + productCost +
                                       ", Tiempo de Procesamiento: " + product.getProcessingTime());
                }

                //mostrar informacion sobre la compra completa
                System.out.println("Cobro completo para el cliente. Costo total de la compra: " + totalCost);
                customer = null; //indicar que no hay mas clientes para este hilo
            } else {
                break;
            }
        }
    }
    
    private double processProduct(Product product) {
        //logica para procesar cada producto, calcular tiempos
         double productCost = product.getPrice();

        try {
            System.out.println(name + " esta procesando el producto: " + product.getName());
            TimeUnit.SECONDS.sleep(product.getProcessingTime()); // Simulación de tiempo para procesar un producto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return productCost;
    }
    public void setNoMoreCustomers() {
        noMoreCustomers = true;
        }
}