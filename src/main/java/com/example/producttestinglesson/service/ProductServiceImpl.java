package com.example.producttestinglesson.service;

import com.example.producttestinglesson.dto.ProductRequest;
import com.example.producttestinglesson.dto.ProductResponse;
import com.example.producttestinglesson.entity.Product;
import com.example.producttestinglesson.repositores.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    // inject the repository here
    private final ProductRepository productRepository;
    private Integer nextId = 1004;
    // mapToEntity
    private Product mapToEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());

        return product;
    }
    // mapToResponse -> convert Entity to Response
    private ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        // create entity product from the request
        var product = mapToEntity(request);
        // set static userID
        product.setUserId(1);
        product.setId(nextId++);
        return mapToResponse(productRepository.createProduct(product));

    }



    @Override
    public List<ProductResponse> findAllProducts() {
        return productRepository.getAllProducts()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }


    @Override
    public ProductResponse updateProduct(Integer id, ProductRequest request) {
        var existingProduct = productRepository.findProductById(id);
        if(existingProduct == null){
            log.info("Product with id {} not found" , id);
            return null;
        }
        if (request.name()!=null)
            existingProduct.setName(request.name());

        if(request.description()!=null)
            existingProduct.setDescription(request.description());
        if(request.price()!=null)
            existingProduct.setPrice(request.price());
        productRepository.updateProduct(existingProduct);
        return mapToResponse(existingProduct);

    }

    @Override
    public boolean deleteProduct(int id) {
        boolean deleted = productRepository.deleteProductById(id);
        if(!deleted) {
            log.info("Product with id {} not found",id);
        }
        return deleted;
    }

    @Override
    public ProductResponse getProdcutByID(Integer id) {
        var product = productRepository.findProductById(id);
        if(product == null) {
            log.info("Product with id {} not found", id);
            return null;
        }
        return mapToResponse(product);
    }
}
