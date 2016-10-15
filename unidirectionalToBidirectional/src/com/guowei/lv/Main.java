package com.guowei.lv;

public class Main {

    public static void main(String[] args) {
	    Customer customer = new Customer("9527", "Zhou");
        System.out.println("Customer " + customer.getName() + ": has " + customer.getNumberOfOrders() + " orders.");

        Order order1 = new Order("1");
        order1.setCustomer(customer);
        System.out.println("Customer " + customer.getName() + ": has " + customer.getNumberOfOrders() + " orders.");

        Order order2 = new Order("2");
        order2.setCustomer(customer);
        System.out.println("Customer " + customer.getName() + ": has " + customer.getNumberOfOrders() + " orders.");
    }
}
