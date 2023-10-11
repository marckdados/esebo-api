package com.pessoal.esebo.controller;

import com.pessoal.esebo.entity.Sale;
import com.pessoal.esebo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Sale>> findAllSales(){
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findAllSales());
    }

    @PostMapping("/save/{id}")
    public ResponseEntity createSale(@PathVariable("id") Long userId, @RequestBody Sale saleToCreate){
        saleService.createSale(userId, saleToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Venda criada com sucesso !");
    }
}
