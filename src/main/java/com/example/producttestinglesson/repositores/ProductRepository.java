package com.example.producttestinglesson.repositores;

import com.example.producttestinglesson.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProductRepository {
    // because we don't work with database yet
    // productList = represent the data storage
    private final List<Product> productList = new ArrayList<>(){{
        add( new Product(1001,"Coca-cola","Nice when cool",23.4f,2));
        add( new Product(1002,"Fanta"," Fantastic Drink",0.75f,4));
        add( new Product(1003,"Sting","Unlimited Sweetness ",0.65f,4));
    }};

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product createProduct(Product product) {
        productList.add(product);
        return product;
    }


    public Product findProductById(Integer id ) {
        return  productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("Product with ID =" + id  + " are not Found")); // it will throw the NoSuchElementException
        // new RescourceNotFoundException
    }
    public boolean deleteProductById(Integer id) {
        return productList.removeIf(product -> product.getId() == id);
    }

    // update product by id
    public Product updateProduct(Product updateProduct ){
        for(int i = 0 ; i<productList.size(); i++){
            var product = productList.get(i);
            if(product.getId() == updateProduct.getId()){
                productList.set(i, updateProduct);
                return updateProduct;
            }
        }
        return null;
    }
}
