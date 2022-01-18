package com.example.tasty.profile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "password")
    private String password;

    public Profile() {}

    public String getId() {
        return id;
    }

    public void setId(String username) {
        this.id = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "username='" + id + '\'' +
                ", password='" + password +
                '}';
    }
}
