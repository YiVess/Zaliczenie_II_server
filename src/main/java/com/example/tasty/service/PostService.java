package com.example.emenu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Value("${post.images.filesystem.path}")
    private String pathToImagesFileSystem;

    public List<String> savePostImages(List<MultipartFile> myImages, String username) throws Exception{

        int numberOfImages = myImages.size();
        List<String> paths = new ArrayList<String>();
        Date date = new Date();

        for(int i=0;i<numberOfImages;i++){
            byte[] bytes = myImages.get(i).getBytes();
            String tempPath = pathToImagesFileSystem + username + "/" + date.getTime() + "/";
            Path path = Paths.get(tempPath);
            Files.createDirectories(path);

            tempPath += myImages.get(i).getOriginalFilename();

            paths.add(tempPath);
            path = Paths.get(tempPath);
            Files.write(path,bytes);
        }

        return paths;
    }

}
