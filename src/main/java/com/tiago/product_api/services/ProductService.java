package com.tiago.product_api.services;

import com.tiago.product_api.entities.Product;
import com.tiago.product_api.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Product findById(Long id){
         return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                 HttpStatus.NOT_FOUND, "Produto não encontrado com o id: " + id));
    }
}
