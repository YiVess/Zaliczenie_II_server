package com.example.tasty.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ImageController {


    @GetMapping(value = "/image")
    @ResponseBody
    public ResponseEntity<Resource> showImage(@RequestParam ("pathToImage") String pathToImage){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","image/jpeg");
        Resource resource = new FileSystemResource(pathToImage);

        return new ResponseEntity<>(resource,headers,HttpStatus.OK);
    }
}
