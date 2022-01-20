package com.example.tasty.profile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://192.168.0.136:5500"})
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/profileLogIn")
    public Profile logProfileIn(@RequestBody Profile profile){

        Profile temp;

        temp = profileService.logIn(profile);

        if(temp == null) {
            return new Profile();
        }
        else {
            temp.setPassword(null);
            temp.likedPostsToJSON();
        }
        return temp;
    }

    @PostMapping("/profileCreate")
    public void createProfile(@RequestBody Profile profile){

        profileService.save(profile);

    }

    public void deleteProfile(){}

    @PostMapping("/profile")
    public void updateProfile(@RequestBody Profile profile){
        profile.likedPostsToDB();
        Profile temp = profileService.getById(profile.getId());
        temp.likedPostsDB = profile.likedPostsDB;
        temp.setDescription(profile.getDescription());
        profileService.update(temp);
    }

    public void blockProfile(){}

    public void warnProfile(){}
}
