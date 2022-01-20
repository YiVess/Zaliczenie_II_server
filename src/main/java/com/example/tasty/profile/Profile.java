package com.example.tasty.profile;

import com.example.tasty.post.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @Transient
    public int[] likedPosts;

    @Column(name = "liked_posts")
    public String likedPostsDB;


    public Profile() {
    }

    public void likedPostsToDB(){

        if(this.likedPosts ==null){
            this.likedPostsDB = null;
            return;
        }

        String temp = new String();
        for(int id:likedPosts){
            temp+=id+";";
        }
        this.likedPostsDB=temp;
    }

    public void likedPostsToJSON(){
        String[] tempTable = this.likedPostsDB.split(";");

        if(tempTable == null){
            this.likedPosts =null;
            return;
        }

        this.likedPosts = new int[tempTable.length];

        for(int i=0; i< tempTable.length;i++){
            this.likedPosts[i] = Integer.parseInt(tempTable[i]);
        }
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
