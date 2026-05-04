package com.tiago.product_api.services;

import com.tiago.product_api.entities.Product;
import com.tiago.product_api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository  repository;

     public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product save(Product product){
        if (product == null){
            throw new IllegalArgumentException("O produto não poder nulo");
        }
        return  repository.save(product);
    }
}
