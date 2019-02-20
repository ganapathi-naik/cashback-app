package com.gnaik.tools.cashback.app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("redeemPoints")
public class ReedemPoints {

    @Id
    private Long orderId;
    private Long accountId;
    private Integer redeemPoints;
    private Date expiryDate;

    public ReedemPoints(Long orderId, Long accountId, Integer redeemPoints, Date expiryDate) {
        this.orderId = orderId;
        this.accountId = accountId;
        this.redeemPoints = redeemPoints;
        this.expiryDate = expiryDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getRedeemPoints() {
        return redeemPoints;
    }

    public void setRedeemPoints(Integer redeemPoints) {
        this.redeemPoints = redeemPoints;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
