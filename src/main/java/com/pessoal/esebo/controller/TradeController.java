package com.pessoal.esebo.controller;

import com.pessoal.esebo.entity.Trade;
import com.pessoal.esebo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trade")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @PostMapping(value = "/save/{id}")
    public void createTrade(@PathVariable("id") Long userId,@RequestBody Trade trade){
        tradeService.createTrade(userId, trade);
    }
    @GetMapping("find-all")
    public List<Trade> findAllTrades(){
        return tradeService.findAllTrades();
    }
}
