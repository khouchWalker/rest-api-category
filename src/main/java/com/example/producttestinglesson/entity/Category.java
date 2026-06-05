package com.example.producttestinglesson.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
   private Integer id;
   private String name;
   private  String description;
   private Boolean isActive;

}
