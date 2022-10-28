package com.SimpleCrud.WebApp.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.SimpleCrud.WebApp.models.Product;

public interface Productrepos extends CrudRepository<Product, Long> {
    
    List<Product> findByNamaContains(String keyword);
}
