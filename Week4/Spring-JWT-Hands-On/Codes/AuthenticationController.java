package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(@RequestHeader("Authorization") String authorizationHeader) {
        LOGGER.info("START authenticate");

        String username = getUser(authorizationHeader);
        LOGGER.info("Username: {}", username);

        String token = generateJwt(username);
        LOGGER.info("Generated Token: {}", token);

        LOGGER.info("END authenticate");

        return new AuthenticationResponse(token);
    }

    private String getUser(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            String base64Credentials = authorizationHeader.substring(6);
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded);
            final String[] values = credentials.split(":", 2);
            return values[0];
        }
        return null;
    }
    
    private String generateJwt(String user) {
        SecretKey key = Keys.hmacShaKeyFor("secretkeysecretkeysecretkeysecretkeysecretkey".getBytes(StandardCharsets.UTF_8));
        
        String token = Jwts.builder()
            .setSubject(user)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + 1200000)) // 20 minutes
            .signWith(key)
            .compact();
            
        LOGGER.debug("Generated Token: {}", token);
        return token;
    }
}