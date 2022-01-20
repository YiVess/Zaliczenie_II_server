package com.example.tasty.post;

import com.example.tasty.post.comment.CommentService;
import com.example.tasty.profile.Profile;
import com.example.tasty.profile.ProfileService;
import com.example.tasty.service.HibernateAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://192.168.0.136:5500"})
@RequestMapping("/api")
public class PostController {

    private final PostService postService;
    private final ProfileService profileService;
    private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, ProfileService profileService, CommentService commentService) {
        this.postService = postService;
        this.profileService = profileService;
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
    public List<Post> getPosts(@PathVariable ("page") int pageNumber, @RequestParam(name = "username", required = false) String username){

        List<Post> posts;

        if(username == null)
            posts = postService.getPage(pageNumber);
        else
            posts = postService.getPage(pageNumber,username);

        for(Post temp:posts){
            temp.setUpTablesForJSON();
        }

        System.out.println(posts);

        return posts;
    }

    public void addComment(){



    }

    @PostMapping(value = "/post/like")
    public void likePost(@RequestBody Profile profile ){

        profile.setPassword(profileService.getById(profile.getId()).getPassword());

        profileService.update(profile);

    }

    public void updatePost(){}

    public void reportPost(){}

    public void deletePost(){}


}
