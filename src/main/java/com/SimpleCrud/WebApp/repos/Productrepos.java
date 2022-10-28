package com.SimpleCrud.WebApp.repos;

import org.springframework.data.repository.CrudRepository;
import com.SimpleCrud.WebApp.models.Product;

public interface Productrepos extends CrudRepository<Product, Long>  {
    
}
