package com.tiago.product_api.repositories;

import com.tiago.product_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> id(Long id);
}

