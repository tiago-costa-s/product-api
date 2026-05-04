package com.tiago.product_api.controllers;

import com.tiago.product_api.entities.Product;
import com.tiago.product_api.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping
    public List<Product> findAll(){
       return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        Product productSave = service.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productSave);
    }
}
