package com.askar.webproject.service.generator;

public class OrderIdGenerator {
    private static int orderId = 0;

    public static int generateOrderId() {
        return orderId++;
    }

    public static int getOrderId() {
        return orderId;
    }
}
