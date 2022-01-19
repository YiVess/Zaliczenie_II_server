package com.example.tasty.post;

import com.example.tasty.post.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @PostMapping(value = "/post")
    public void addPost(@RequestParam (value = "images", required = false) MultipartFile[] images, @RequestParam ("postData") String[] postData, @RequestParam ("postAuthor") String username){

        Post post = new Post(postData, username);

        if(images != null){
            try {
                post.setPathsToImages(postService.savePostImages(images, username));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        post.setDate(new Date());

        post.setUpTablesForDB();
        System.out.println(post);
        postService.save(post);
    }

    @GetMapping(value = "/post/{page}")
    public List<Post> getPosts(@PathVariable ("page") int pageNumber){

        List<Post> posts = postService.getPage(pageNumber);

        for(Post temp:posts){
            temp.setUpTablesForJSON();
        }

        System.out.println(posts);

        return posts;
    }

    public void addComment(){}

    public void likePost(){}

    public void updatePost(){}

    public void reportPost(){}

    public void deletePost(){}


}
