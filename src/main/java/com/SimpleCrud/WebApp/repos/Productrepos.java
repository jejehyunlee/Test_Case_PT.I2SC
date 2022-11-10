package com.SimpleCrud.WebApp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SimpleCrud.WebApp.models.Product;

public interface Productrepos extends JpaRepository<Product, Long> {
          
    List<Product> findByNamaContains(String keyword);

    Product findByNoreg(String noreg);
    
    Product findByNama(String nama);
}
