package com.SimpleCrud.WebApp.repository;

import java.util.List;

import com.SimpleCrud.WebApp.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeRepo extends JpaRepository<Employe, Long> {
    
    
    List<Employe> findByNamaContains(String keyword);
    @Query("SELECT p FROM Employe p WHERE CONCAT(p.nik, ' ', p.nama) LIKE %?1%")
    List<Employe> findByNikContains(String keyword);

    Employe findByNik(String nik);
    
    Employe findByNama(String nama);
}
