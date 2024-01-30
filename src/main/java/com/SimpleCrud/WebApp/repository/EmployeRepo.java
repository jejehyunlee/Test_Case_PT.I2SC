package com.SimpleCrud.WebApp.repository;

import java.util.List;

import com.SimpleCrud.WebApp.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public interface EmployeRepo extends JpaRepository<Employe, Long> {
    
    
    List<Employe> findByNamaContaining(String keyword);

    List<Employe> findByNikOrNamaContaining(String nik, String nama);

    Employe findByNik(String nik);
    
    Employe findByNama(String nama);



}
