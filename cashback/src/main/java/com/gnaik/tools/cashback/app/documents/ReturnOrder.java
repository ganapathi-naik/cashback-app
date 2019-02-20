package com.gnaik.tools.cashback.app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Document("returnOrder")
public class ReturnOrder {

    @Id
    private Long id;
    private long orderId;
    private double amount;
    private List<Item> items;

    public ReturnOrder(Long id, long orderId, double amount, List<Item> items) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public long getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItems(List<Item> items) {
        if (Objects.isNull(items))
            return;
        if (Objects.isNull(this.items)) {
            items = new LinkedList<>();
        }
        this.items.addAll(items);
    }
}
