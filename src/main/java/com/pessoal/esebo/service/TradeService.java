package com.pessoal.esebo.service;

import com.pessoal.esebo.entity.Trade;
import com.pessoal.esebo.entity.User;
import com.pessoal.esebo.repository.TradeRepository;
import com.pessoal.esebo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private UserRepository userRepository;

    public void createTrade(Long userId, Trade tradeToCreate){
        User userFound = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        Trade tradeSaved = tradeRepository.save(tradeToCreate);
        tradeRepository.insertTradeInUser(userFound.getId(), tradeSaved.getId());
    }

    public List<Trade> findAllTrades(){
        return tradeRepository.findAll();
    }

}
