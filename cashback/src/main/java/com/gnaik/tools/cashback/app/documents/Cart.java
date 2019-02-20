package com.gnaik.tools.cashback.app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cart")
public class Cart {

    @Id
    private Long id;
    private Long accountId;
    private List<Item> items;

    public Cart(Long id, Long accountId, List<Item> items) {
        this.id = id;
        this.accountId = accountId;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        double amount = 0.0;
        for (Item item : items) {
            amount += item.getPrice() * item.getQuantity();
        }
        return amount;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getAccountId() {
        return accountId;
    }
}
