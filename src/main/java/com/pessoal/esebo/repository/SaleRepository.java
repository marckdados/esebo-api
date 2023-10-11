package com.pessoal.esebo.repository;

import com.pessoal.esebo.entity.Sale;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tb_user_sales (tb_user_id, sales_id) VALUES (:userId, :saleId)", nativeQuery = true)
    void insertSaleInUser(@Param("userId") Long userId, @Param("saleId") Long saleId);
}
