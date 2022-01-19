package com.example.tasty.post;

import com.example.tasty.service.HibernateAbstractService;
import org.hibernate.Session;
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
public class PostService extends HibernateAbstractService<Post, Integer> {

    @Value("${post.images.filesystem.path}")
    private String pathToImagesFileSystem;

    public PostService() {
        super(Post.class);
    }

    public String[] savePostImages(MultipartFile[] myImages, String username) throws Exception{

        String[] paths = new String[myImages.length];
        int i=0;
        Date date = new Date();

        for (MultipartFile myImage : myImages) {
            byte[] bytes = myImage.getBytes();
            String tempPath = pathToImagesFileSystem + username + "/" + date.getTime() + "/";
            Path path = Paths.get(tempPath);
            Files.createDirectories(path);

            tempPath += myImage.getOriginalFilename();

            paths[i] = tempPath;
            path = Paths.get(tempPath);
            Files.write(path, bytes);
            i++;
        }

        return paths;
    }

    public List<Post> getPage(int pageNumber){

        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from Post order by date desc ").setFirstResult(pageNumber).setMaxResults(5).getResultList();
    }

}
