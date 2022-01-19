package com.example.tasty.security;


import com.example.tasty.profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SecurityController {

    private final WebTokenHandler webTokenHandler;

    @Autowired
    public SecurityController(WebTokenHandler webTokenHandler) {
        this.webTokenHandler = webTokenHandler;
    }

    @PostMapping("/webTokenFirst")
    public WebToken createFirstWebToken(@RequestBody Profile profile){

        System.out.println(profile);

        return webTokenHandler.generateToken(profile.getId());

    }

    @PostMapping("/webToken")
    public WebToken checkWebToken(@RequestBody WebToken webToken){

        System.out.println(webToken);

        if(webTokenHandler.isTokenValid(webToken)){
            return webTokenHandler.generateToken(webToken.getUsername());
        }
        else {
            return new WebToken();
        }
    }
}
