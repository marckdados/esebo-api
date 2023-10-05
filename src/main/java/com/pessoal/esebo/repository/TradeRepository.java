package com.pessoal.esebo.repository;

import com.pessoal.esebo.entity.Trade;
import com.pessoal.esebo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tb_user_trades (tb_user_id, trades_id) VALUES (:userId, :tradeId)", nativeQuery = true)
    void insertTradeInUser(@Param("userId") Long userId, @Param("tradeId") Long tradeId);
}
