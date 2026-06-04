package com.example.producttestinglesson.service;


import com.example.producttestinglesson.dto.ProductRequest;
import com.example.producttestinglesson.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface ProductService {
    ProductResponse createProduct(ProductRequest product);
    List<ProductResponse> findAllProducts();
    ProductResponse getProdcutByID(Integer id);
    ProductResponse updateProduct(Integer id, ProductRequest product);
    boolean deleteProduct(int id);

}
