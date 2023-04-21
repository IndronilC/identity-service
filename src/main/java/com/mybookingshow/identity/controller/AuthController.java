package com.mybookingshow.identity.controller;

import com.mybookingshow.identity.entity.UserCredential;
import com.mybookingshow.identity.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public String createUser(@RequestBody UserCredential userCredential){
        authService.saveUser(userCredential);
        log.info("User has been successfully added to the system");
        return "User has been successfully added to the system";
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserCredential userCredential){
        return authService.generateToken(userCredential.getFirstName());
    }

    @PostMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        authService.validateToken(token);
        return "token is valid";
    }

}
