package com.pessoal.esebo.controller;

import com.pessoal.esebo.entity.User;
import com.pessoal.esebo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/save")
    public ResponseEntity<String> createUser(@RequestBody User userToCreate){
        userService.createUser(userToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso !");
    }
    @GetMapping(value = "/find-all")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> allUsers = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    @GetMapping(value = "/find-user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User userExists = userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userExists);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long id, @RequestBody User userToUpdate){
        userService.updateUser(id, userToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário atualizado com sucesso !");
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso !");
    }

}
