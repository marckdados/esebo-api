package com.pessoal.esebo.service;


import com.pessoal.esebo.entity.User;
import com.pessoal.esebo.repository.UserRepository;
import com.pessoal.esebo.utils.handler.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User userToCreate){
        Optional<User> userWithEmailExists = userRepository.findUserByEmail(userToCreate.getEmail());
        if(userWithEmailExists.isPresent()){
            throw new IllegalArgumentException("ERROR: Email já existente !");
        }
        userRepository.save(userToCreate);
    }

    public List<User> findAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }
    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void updateUser(Long id, User userToUpdate){
        User userFound = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        userFound.setUsername(userToUpdate.getUsername());
        userFound.setEmail(userToUpdate.getEmail());
        userFound.setPassword(userToUpdate.getPassword());
        userRepository.save(userFound);
    }

    public void deleteUser(Long id){
        User userFound = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        userRepository.delete(userFound);
    }
}
