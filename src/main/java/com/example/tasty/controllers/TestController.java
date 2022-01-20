package com.example.tasty.controllers;

import com.example.tasty.profile.ProfileService;
import com.example.tasty.profile.Profile;
import com.example.tasty.security.WebToken;
import com.example.tasty.security.WebTokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private WebTokenHandler webTokenHandler;

    @Autowired
    private ProfileService profileService;

    @GetMapping("/test")
    public void test(){



        WebToken webToken = webTokenHandler.generateToken("Chmielu");

        System.out.println(webToken);
        System.out.println(webTokenHandler.isTokenValid(webToken));

        Profile profile = new Profile();

        profile.setPassword("123");
        profile.setId("test");

        profileService.save(profile);

        Profile temp = profileService.logIn(profile);

        System.out.println(temp);

        profileService.deleteById(profile.getId());
    }

}
