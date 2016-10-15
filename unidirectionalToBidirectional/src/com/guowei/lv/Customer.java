package com.guowei.lv;


import java.util.HashSet;
import java.util.Set;

class Customer {

    private String id;

    private String name;

    private Set<Order> orders;

    Customer(String id, String name) {
        this.id = id;
        this.name = name;
        orders = new HashSet<>();
    }

    String getName() {
        return name;
    }

    /**
     * Should be used in Order class only
     * @return
     */
    Set<Order> friendOrders() {
        return orders;
    }

    int getNumberOfOrders() {
        return orders.size();
    }

}
