package com.example.tasty.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Transient
    private String[] ingredients;
    @Column(name = "ingredients")
    private String ingredientsDB;

    @Transient
    private String[] steps;
    @Column(name = "steps")
    private String stepsDB;

    @Transient
    private String[] tags;
    @Column(name = "tags")
    private String tagsDB;

    @Column(name = "added")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw  ")
    private Date date;

    @Transient
    private String[] pathsToImages;

    @Column(name = "images")
    private String pathsDB;

    @Column(name = "author")
    private String author;

    public Post() {
    }

    public Post(String[] postData, String author){
        this.description = postData[0];
        this.ingredientsDB = postData[1];
        this.stepsDB = postData[2];
        this.tagsDB = postData[3];
        this.author = author;

        this.steps = stepsDB.split(",");
        this.ingredients = ingredientsDB.split(",");
        this.tags = tagsDB.split(",");

    }

    public void setUpTablesForJSON(){

        this.ingredients = ingredientsDB.split(",");
        this.steps = stepsDB.split(",");
        this.tags = tagsDB.split(",");
        if(this.pathsDB != null)
        this.pathsToImages = pathsDB.split(",");
    }

    public void setUpTablesForDB(){
        this.ingredientsDB = "";
        for(int i=0;i< ingredients.length;i++){
            if(i+1< ingredients.length)
                this.ingredientsDB+=ingredients[i]+",";
            else{
                this.ingredientsDB+=ingredients[i];
            }
        }
        this.stepsDB = "";
        for(int i=0;i< steps.length;i++){
            if(i+1< steps.length)
                this.stepsDB+=steps[i]+",";
            else{
                this.stepsDB+=steps[i];
            }
        }
        this.tagsDB = "";
        for(int i=0;i< tags.length;i++){
            if(i+1< tags.length)
                this.tagsDB+=tags[i]+",";
            else{
                this.tagsDB+=tags[i];
            }
        }
        if (pathsToImages != null) {
            this.pathsDB = "";
            for(int i=0;i< pathsToImages.length;i++){
                if(i+1< pathsToImages.length)
                    this.pathsDB+=pathsToImages[i]+",";
                else{
                    this.pathsDB+=pathsToImages[i];
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", ingredientsDB='" + ingredientsDB + '\'' +
                ", steps=" + Arrays.toString(steps) +
                ", stepsDB='" + stepsDB + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", tagsDB='" + tagsDB + '\'' +
                ", date=" + date +
                ", pathsToImages=" + pathsToImages +
                ", pathsDB='" + pathsDB + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
