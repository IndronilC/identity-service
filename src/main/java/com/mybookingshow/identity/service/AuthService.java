package com.mybookingshow.identity.service;

import com.mybookingshow.identity.entity.UserCredential;
import com.mybookingshow.identity.repository.UserCredentialRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {
    @Autowired
    private final UserCredentialRepository userCredentialRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String saveUser(UserCredential userCredential) {
        passwordEncoder.encode(userCredential.getPassword());
        userCredentialRepository.save(userCredential);
        log.info("Added user successfully");
        return "Added User Successfully";
    }

}
