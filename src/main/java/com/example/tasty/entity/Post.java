package com.example.emenu.entity;

import java.util.List;

public class Post {

    private String description;
    private List<String> ingredients;
    private List<String> steps;
    private List<String> tags;
    private List<String> pathsToImages;

    public Post() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getPathsToImages() {
        return pathsToImages;
    }

    public void setPathsToImages(List<String> pathToImages) {
        this.pathsToImages = pathToImages;
    }

    @Override
    public String toString() {
        return "Post{" +
                "description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                ", tags=" + tags +
                ", pathsToImages=" + pathsToImages +
                '}';
    }
}
