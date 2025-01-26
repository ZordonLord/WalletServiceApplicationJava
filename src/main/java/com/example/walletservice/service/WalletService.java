package com.example.walletservice.service;

import com.example.walletservice.dto.OperationRequest;
import com.example.walletservice.repository.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional
    public void processOperation(OperationRequest request) {

    }

    public double getBalance(UUID walletId) {
        return walletRepository.findBalanceByWalletId(walletId)
                .orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
    }
}