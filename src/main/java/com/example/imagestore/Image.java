package com.example.imagestore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Image {
    Integer id;
    Long size;
    String name;
    String title;
    String description;
    String image;
}
