package com.example.tasty.profile.entity;

import javax.persistence.*;

@Entity
@Table(name = "profile_data")
public class ProfileData {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "path_to_profile_photo")
    private String pathToProfilePhoto;

    @Transient
    private int numberOfProfilesFollowed;
    @Transient
    private int numberOfProfilesFollowing;


    public ProfileData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String username) {
        this.id = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathToProfilePhoto() {
        return pathToProfilePhoto;
    }

    public void setPathToProfilePhoto(String pathToProfilePhoto) {
        this.pathToProfilePhoto = pathToProfilePhoto;
    }

    public int getNumberOfProfilesFollowed() {
        return numberOfProfilesFollowed;
    }

    public void setNumberOfProfilesFollowed(int numberOfProfilesFollowed) {
        this.numberOfProfilesFollowed = numberOfProfilesFollowed;
    }

    public int getNumberOfProfilesFollowing() {
        return numberOfProfilesFollowing;
    }

    public void setNumberOfProfilesFollowing(int numberOfProfilesFollowing) {
        this.numberOfProfilesFollowing = numberOfProfilesFollowing;
    }

    @Override
    public String toString() {
        return "ProfileData{" +
                "username='" + id + '\'' +
                ", description='" + description + '\'' +
                ", pathToProfilePhoto='" + pathToProfilePhoto + '\'' +
                ", numberOfProfilesFollowed=" + numberOfProfilesFollowed +
                ", numberOfProfilesFollowing=" + numberOfProfilesFollowing +
                '}';
    }
}
