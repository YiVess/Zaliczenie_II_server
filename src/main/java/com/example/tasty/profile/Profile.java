package com.example.tasty.profile;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class Profile {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "password")
    private String password;
    @Column(name = "description")
    private String description;
    @Column(name = "path_to_profile_photo")
    private String pathToProfilePhoto;

    @Transient
    private int numberOfProfilesFollowed;
    @Transient
    private int numberOfProfilesFollowing;


    public Profile() {
    }


    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", pathToProfilePhoto='" + pathToProfilePhoto + '\'' +
                ", numberOfProfilesFollowed=" + numberOfProfilesFollowed +
                ", numberOfProfilesFollowing=" + numberOfProfilesFollowing +
                '}';
    }
}
