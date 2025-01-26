package com.example.walletservice.repository;

import com.example.walletservice.entity.Wallet;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Wallet> findById(UUID walletId);

    @Query("SELECT w.balance FROM Wallet w WHERE w.walletId = :walletId")
    Optional<Double> findBalanceByWalletId(UUID walletId);
}