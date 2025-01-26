package com.example.walletservice.service;

import com.example.walletservice.dto.OperationRequest;
import com.example.walletservice.entity.Wallet;
import com.example.walletservice.repository.WalletRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WalletServiceTest {

    private WalletRepository walletRepository;
    private WalletService walletService;

    @BeforeEach
    public void setUp() {
        walletRepository = Mockito.mock(WalletRepository.class);
        walletService = new WalletService(walletRepository);
    }

    @Test
    public void testGetBalance_WalletExists() {
        UUID walletId = UUID.randomUUID();
        Wallet wallet = new Wallet();
        wallet.setWalletId(walletId);
        wallet.setBalance(1000.0);

        when(walletRepository.findBalanceByWalletId(walletId)).thenReturn(Optional.of(1000.0));

        double balance = walletService.getBalance(walletId);
        assertEquals(1000.0, balance);
    }

    @Test
    public void testProcessOperation_Deposit() {
        UUID walletId = UUID.randomUUID();
        Wallet wallet = new Wallet();
        wallet.setWalletId(walletId);
        wallet.setBalance(500.0);

        when(walletRepository.findById(walletId)).thenReturn(Optional.of(wallet));

        OperationRequest request = new OperationRequest();
        request.setWalletId(walletId);
        request.setOperationType("DEPOSIT");
        request.setAmount(500.0);

        walletService.processOperation(request);

        assertEquals(1000.0, wallet.getBalance());
        verify(walletRepository, times(1)).save(wallet);
    }
}