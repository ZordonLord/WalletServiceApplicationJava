package com.example.walletservice.dto;

import java.util.UUID;

public class OperationRequest {
    private UUID walletId;
    private String operationType; // "DEPOSIT" or "WITHDRAW"
    private double amount;

    // Getters and setters
    public UUID getWalletId() {
        return walletId;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}