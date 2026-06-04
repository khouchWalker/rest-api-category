package com.example.producttestinglesson.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {

    private int id;
    private String name;
    private String description ;
    private float price;
    private int userId;
}
