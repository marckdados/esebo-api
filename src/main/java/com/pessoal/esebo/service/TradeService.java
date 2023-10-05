package com.pessoal.esebo.service;

import com.pessoal.esebo.entity.Trade;
import com.pessoal.esebo.entity.User;
import com.pessoal.esebo.repository.TradeRepository;
import com.pessoal.esebo.repository.UserRepository;
import com.pessoal.esebo.utils.handler.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private UserRepository userRepository;

    public void createTrade(Long userId, Trade tradeToCreate){
        User userFound = userRepository.findById(userId).orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado !"));
        Trade tradeSaved = tradeRepository.save(tradeToCreate);
        tradeRepository.insertTradeInUser(userFound.getId(), tradeSaved.getId());
    }

    public List<Trade> findAllTrades(){
        return tradeRepository.findAll();
    }

}
