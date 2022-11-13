package com.example.imagestore.controller;

import com.example.imagestore.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin // Allow all domain origins.
@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

    int counter;
    List<Image> images;

    public ImageController() {
        images = new ArrayList<>();
    }

    @GetMapping()
    public ResponseEntity<List<Image>> findAll() {
        System.out.println("Found images:" + images.size());
        return ResponseEntity.ok().body(images);
    }

    @GetMapping("/byuser/{user}")
    public ResponseEntity<List<Image>> findByUser(@PathVariable String user) {
        List<Image> userImages = images.stream().filter(element -> element.getUser().equals(user)).collect(Collectors.toList());
        System.out.println("Found images:" + userImages.size());
        return ResponseEntity.ok().body(userImages);
    }

    @PostMapping()
    public ResponseEntity<Image> createImage(@RequestBody Image image) {
        image.setId(counter++);
        image.setCreated(new Date());
        images.add(image);
        System.out.println("Added image: ${}");
        return ResponseEntity.ok().body(image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Image> deleteImage(@PathVariable("id") Integer id) {
        Image deleteImage = images.stream().filter( element -> element.getId().equals(id)).findFirst().get();
        images.remove(deleteImage);
        System.out.println("removed image: ${}");
        return ResponseEntity.ok().body(deleteImage);
    }

}
