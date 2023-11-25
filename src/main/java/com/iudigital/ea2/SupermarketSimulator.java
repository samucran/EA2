package com.iudigital.ea2;


import java.util.ArrayList;
import java.util.List;

public class SupermarketSimulator {
    private List<Cashier> cashiers;
    private List<Customer> customers;

    public SupermarketSimulator() {
        cashiers = new ArrayList<>();
        customers = new ArrayList<>();
        initializeCashiers();
        initializeCustomers();
    }
    
    private void initializeCashiers() {
        for (int i = 0; i < 3; i++) {
            cashiers.add(new Cashier("Cajera " + (i + 1)));
        }
    }
    
    private void initializeCustomers() {
        for (int i = 0; i < 5; i++) {
            customers.add(new Customer());
        }
    }

    public void startSimulation() {
        //iniciar la simulacion aquí.
        List<Thread> cashierThreads = new ArrayList<>();
        for (Cashier cashier : cashiers) {
            Thread cashierThread = new Thread(() -> {
                while (true) {
                    Customer customer = getNextCustomer();
                    if (customer == null) {
                        break; //no hay mas clientes, la cajera termina su ejecucion
                    }
                    cashier.processPurchase(customer);
                }
            });
            cashierThreads.add(cashierThread);
            cashierThread.start();
        }

        //crear hilos para los clientes
        System.out.println("Simulacion del supermercado iniciada.");
        List<Thread> customerThreads = new ArrayList<>();
        for (Customer customer : customers) {
            Thread customerThread = new Thread(() -> {
                //logica del cliente, como agregar productos al carrito
            });
            customerThreads.add(customerThread);
            customerThread.start();
        }

        //esperar a que todos los hilos de clientes terminen
        for (Thread customerThread : customerThreads) {
            try {
                customerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //indicar a las cajeras que no hay mas clientes
        for (Cashier cashier : cashiers) {
            cashier.setNoMoreCustomers();
        }

        //esperar a que todos los hilos de cajeras terminen
        for (Thread cashierThread : cashierThreads) {
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Simulacion del supermercado finalizada.");

        //calcular y mostrar el tiempo total de cobro para todas las compras
    }

    private synchronized Customer getNextCustomer() {
        if (customers.isEmpty()) {
            return null;
        }
        return customers.remove(0);
    }
}
