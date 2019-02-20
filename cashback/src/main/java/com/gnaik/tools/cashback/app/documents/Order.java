package com.gnaik.tools.cashback.app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "order")
public class Order {

    @Transient
    public static final String SEQUENCE_NAME = "orders_sequence";

    @Id
    private Long id;
    private Long accountId;
    private String status;
    private double totalAmount;
    private List<Item> items;
    private Date date;

    public Order(Long accountId, Date date, String status,
                 double totalAmount, List<Item> items) {
        this.accountId = accountId;
        this.date = date;
        this.status = status;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getAccountId() {
        return accountId;
    }
}
