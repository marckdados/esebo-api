package com.pessoal.esebo.controller;

import com.pessoal.esebo.entity.Trade;
import com.pessoal.esebo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trade")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @PostMapping(value = "/save/{id}")
    public ResponseEntity createTrade(@PathVariable("id") Long userId, @RequestBody Trade trade){
        tradeService.createTrade(userId, trade);
        return ResponseEntity.status(HttpStatus.CREATED).body("Troca criada com sucesso !");
    }
    @GetMapping("find-all")
    public ResponseEntity<List<Trade>> findAllTrades(){
        List<Trade> trades = tradeService.findAllTrades();
        return ResponseEntity.status(HttpStatus.OK).body(trades);
    }
}
