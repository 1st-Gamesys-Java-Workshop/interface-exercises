package com.gamesys.sample.reimbursement.core;

import java.math.BigDecimal;

public class Reimbursement {

    private String itemName;
    private BigDecimal amount;
    private String receiptUrl;

    public Reimbursement(String itemName, BigDecimal amount, String receiptUrl) {
        this.itemName = itemName;
        this.amount = amount;
        this.receiptUrl = receiptUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public void setReceiptUrl(String receiptUrl) {
        this.receiptUrl = receiptUrl;
    }
}
