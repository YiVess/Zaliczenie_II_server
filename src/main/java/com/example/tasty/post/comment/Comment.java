package com.example.tasty.post.comment;


import com.example.tasty.post.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private int id;
    private String text;
    private Post post;
    private String author;
    private Comment comment;

    public Comment() {
    }

    public Comment(String text, Post post, String author) {
        this.text = text;
        this.post = post;
        this.author = author;
    }

    public Comment(String text, Post post, Comment comment) {
        this.text = text;
        this.post = post;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", post=" + post +
                ", author='" + author + '\'' +
                ", comment=" + comment +
                '}';
    }
}
