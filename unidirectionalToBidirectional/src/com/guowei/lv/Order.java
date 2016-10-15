package com.guowei.lv;

class Order {
    private String id;
    private Customer customer;

    Order(String id) {
        this.id = id;
    }

    void setCustomer(Customer customer) {

        // remove this order from previous customer
        if (this.customer != null) {
            this.customer.friendOrders().remove(this);
        }
        this.customer = customer;

        // add this order to the new customer
        if (this.customer != null) {
            this.customer.friendOrders().add(this);
        }
    }

    private String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return getId().equals(order.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
