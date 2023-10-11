package com.pessoal.esebo.service;

import com.pessoal.esebo.entity.Sale;
import com.pessoal.esebo.entity.Trade;
import com.pessoal.esebo.entity.User;
import com.pessoal.esebo.repository.SaleRepository;
import com.pessoal.esebo.repository.UserRepository;
import com.pessoal.esebo.utils.handler.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    private UserRepository userRepository;

    public List<Sale> findAllSales(){
        List<Sale> sales = saleRepository.findAll();
        if(sales.isEmpty()){
            throw new NoSuchElementException();
        }
        return sales;
    }

    public void createSale(Long userId, Sale saleToCreate){
        User userFound = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        Sale saleSaved = saleRepository.save(saleToCreate);
        saleRepository.insertTradeInUser(userFound.getId(), saleSaved.getId());
    }
}
