package com.example.walletservice.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    private UUID walletId;

    @Column(nullable = false)
    private double balance;

    public void setWalletId(UUID walletId) {
    }

    public void setBalance(double v) {
    }

    public double getBalance() {
        return 0;
    }

    // Getters and setters
}
