package com.askar.webproject.model.entity;

import com.askar.webproject.service.generator.OrderIdGenerator;

import java.util.*;

public class Order extends Entity {
    private static final long serialVersionUID = 42L;
    private int orderId;
    private double price;

    private int accountId;

    private Map<Product, Integer> products = new HashMap<>();

    public Order() {
        orderId = OrderIdGenerator.generateOrderId();
    }

    public void addProduct(Product product, int amount) {
        if (products.containsKey(product)) {
            int prevAmount = products.get(product);
            int currentAmount = prevAmount + amount;
            products.replace(product, prevAmount, currentAmount);
        } else {
            products.put(product, amount);
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId &&
                Double.compare(order.price, price) == 0 &&
                Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, price, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", price=" + price +
                ", products=" + products +
                '}';
    }
}
