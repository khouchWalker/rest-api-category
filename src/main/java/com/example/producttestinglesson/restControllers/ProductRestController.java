package com.example.producttestinglesson.restControllers;

import com.example.producttestinglesson.dto.ProductRequest;
import com.example.producttestinglesson.dto.ProductResponse;
import com.example.producttestinglesson.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductRestController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductResponse getProductByID(@PathVariable Integer id){
        return productService.getProdcutByID(id);

    }
    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        return productService.createProduct(request);
    }

    @PatchMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Integer id, @RequestBody ProductRequest request){
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProductById(@PathVariable int id) {
        return productService.deleteProduct(id);
    }



}
