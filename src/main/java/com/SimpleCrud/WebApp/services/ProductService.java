package com.SimpleCrud.WebApp.services;

import java.util.Optional;

// import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SimpleCrud.WebApp.models.Product;
import com.SimpleCrud.WebApp.repos.Productrepos;

@Service
@Transactional
public class ProductService {

    @Autowired
    public Productrepos Prepo;

    public Iterable<Product> findAll(){
        return Prepo.findAll();
    }

    public void addProduct (Product product){
        Prepo.save(product);
    }

    public void deletById (long id){
        Prepo.deleteById(id);
    }

    public Optional<Product> findById(Long id) {
       return Prepo.findById(id);
    }

    public void updateProduct(Product product) {
        Prepo.save(product);

    }
    
    
}



