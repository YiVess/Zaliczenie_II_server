package com.example.tasty.profile;

import com.example.tasty.profile.DAO.ProfileDAO;
import com.example.tasty.profile.DAO.ProfileDataDAO;
import com.example.tasty.profile.entity.Profile;
import com.example.tasty.profile.entity.ProfileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfileService {

    private final ProfileDAO profileDAO;
    private final ProfileDataDAO profileDataDAO;

    @Autowired
    public ProfileService(ProfileDAO profileDAO, ProfileDataDAO profileDataDAO) {
        this.profileDAO = profileDAO;
        this.profileDataDAO = profileDataDAO;
    }

    @Transactional
    public ProfileData logProfileIn(Profile profile){

        if(profileDAO.isLoginSuccessful(profile)){
            return profileDataDAO.getById(profile.getId());
        }
        else {
            return null;
        }
    }

    @Transactional
    public void createProfile(Profile profile){
        if (profile.getId().length() <=45 && profile.getPassword().length()<=45){
            profileDAO.save(profile);


            ProfileData tempProfileData = new ProfileData();
            tempProfileData.setId(profile.getId());

            profileDataDAO.save(tempProfileData);


        }
    }

    @Transactional
    public void updateProfile(Profile profile){
        if (profile.getId().length() <=45 && profile.getPassword().length()<=45 && profileDAO.isLoginSuccessful(profile)){
            profileDAO.update(profile);
        }
    }

    @Transactional
    public void deleteProfile(Profile profile){
        if(profileDAO.isLoginSuccessful(profile)){
            profileDAO.deleteById(profile.getId());
            profileDataDAO.deleteById(profile.getId());
        }
    }

    public int getFollowedNumber(String username){
        return 0;
    }
    public int getFollowingNumber(String username){
        return 0;
    }

    public List<ProfileData> getFollowedList(String username){
        return null;
    }

    public List<ProfileData> getFollowingList(String username){
        return null;
    }

}
