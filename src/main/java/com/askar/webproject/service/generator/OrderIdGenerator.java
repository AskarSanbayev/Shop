package com.askar.webproject.service.generator;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderIdGenerator {
    private static AtomicInteger orderId = new AtomicInteger(0);

    public static int generateOrderId() {
        return orderId.incrementAndGet();
    }

    public static int getOrderId() {
        return orderId.get();
    }
}
