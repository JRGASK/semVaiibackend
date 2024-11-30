package com.example.semestralna_praca_vaii.controller.login;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {



    @GetMapping
    public ResponseEntity<Void> login(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
