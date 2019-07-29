package com.askar.webproject.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Order extends Entity {
    private static final long serialVersionUID = 42L;
    private long number;
    private List<Product> deviceList = new ArrayList<>();

    public Order() {

    }
}
