package com.pessoal.esebo.repository;

import com.pessoal.esebo.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query(value = "INSERT INTO tb_user_sales (tb_user_id, sales_id) VALUES (:userId, :saleId)", nativeQuery = true)
    void insertTradeInUser(@Param("userId") Long userId, @Param("saleId") Long saleId);
}
