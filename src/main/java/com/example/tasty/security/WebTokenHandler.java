package com.example.tasty.security;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

@Component
public class WebTokenHandler {

    private final HashMap<String, String> mappedCharacters;

    private final String secretKey;

    public WebTokenHandler() {

        this.mappedCharacters = new HashMap<String,String>();
        this.secretKey = "secret";
    }

    public WebToken generateToken(String username){

        WebToken webToken = new WebToken();

        webToken.setUsername(username);

        LocalDateTime localDateTime = LocalDateTime.now();

        webToken.setExpiryDate(localDateTime.plusHours(1).toString());

        webToken.setToken(encodeToken(webToken));

        return webToken;
    }

    public boolean isTokenValid(WebToken webToken){

        LocalDateTime localDateTime = LocalDateTime.now();

        if(localDateTime.isAfter(LocalDateTime.parse(webToken.getExpiryDate())))
            return false;

        if(webToken.getToken().equals(encodeToken(webToken)))
            return true;
        else
            return false;
    }

    private String encodeToken(WebToken webToken){

        String token = webToken.getUsername() + webToken.getExpiryDate() + this.secretKey;

        char[] tokenAsCharArray = token.toCharArray();

        Random random = new Random();

        char[] username = webToken.getUsername().toCharArray();
        char[] expiryDate = webToken.getExpiryDate().toCharArray();
        long seed = 0;

        for(char temp: expiryDate){
            seed += temp;
        }
        for(char temp:username){
            seed += temp;
        }

        random.setSeed(seed);

        int tempRandomNumber;
        for(int i = 0; i< tokenAsCharArray.length; i++){

            if(this.mappedCharacters.containsKey(String.valueOf(tokenAsCharArray[i]))) {
                tokenAsCharArray[i] = this.mappedCharacters.get(String.valueOf(tokenAsCharArray[i])).charAt(0);
            }

            tempRandomNumber = random.nextInt(10);
            if(tempRandomNumber % 2 ==0){
                tokenAsCharArray[i] += tempRandomNumber;
            }
            else {
                tokenAsCharArray[i] -= tempRandomNumber;
            }

            if(this.mappedCharacters.containsKey(String.valueOf(tokenAsCharArray[i]))) {
                tokenAsCharArray[i] = this.mappedCharacters.get(String.valueOf(tokenAsCharArray[i])).charAt(0);
            }
        }
        token = String.copyValueOf(tokenAsCharArray);
        return token;
    }
}
