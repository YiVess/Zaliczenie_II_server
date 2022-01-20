package com.example.tasty.restControllers;

import com.example.tasty.post.Post;
import com.example.tasty.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(value = "/postImages/{username}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> uploadPostImages(@RequestPart("images") List<MultipartFile> images, @PathVariable ("username") String username){

        List<String> returnValue=null;

        try {
            returnValue = postService.savePostImages(images, username);
        }catch (Exception exception){
            exception.printStackTrace();
        }

        for(String temp : returnValue){
            System.out.println(temp);
        }
        return returnValue;
    }

    @PostMapping(value = "/postData/{username}")
    public void uploadPostData(@RequestBody Post post, @PathVariable ("username") String username){

        System.out.println(post);

    }
}
