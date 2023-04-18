package com.mybookingshow.identity.controller;

import com.mybookingshow.identity.entity.UserCredential;
import com.mybookingshow.identity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public void createUser(@RequestBody UserCredential userCredential){
        authService.saveUser(userCredential);

    }

    @GetMapping("/token")
    public void getToken(@RequestBody UserCredential userCredential){
        authService.generateToken(userCredential.getFirstName());
    }

    @PostMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        authService.validateToken(token);
        return "token is valid";
    }

}
