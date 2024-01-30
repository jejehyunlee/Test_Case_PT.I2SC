package com.SimpleCrud.WebApp.services;

import java.util.List;
import java.util.Optional;

// import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SimpleCrud.WebApp.models.Employe;
import com.SimpleCrud.WebApp.repository.EmployeRepo;

@Service
@Transactional
public class EmployeService {

    @Autowired
    public EmployeRepo employeRepo;

    public Iterable<Employe> findAll(){
        return employeRepo.findAll();
    }

    public void addEmployee(Employe employe){
        employeRepo.save(employe);
    }

    public void deletById (long id){
        employeRepo.deleteById(id);
    }

    public Optional<Employe> findById(Long id) {
       return employeRepo.findById(id);
    }

    public void updateEmployee(Employe employe) {
        employeRepo.save(employe);

    }
    
    public List<Employe> FindByName(String keyword) {

        return employeRepo.findByNamaContains(keyword);

    }
    public List<Employe> FindByNik(String keyword) {
        if(keyword != null){
            return employeRepo.findByNikContains(keyword);
        }
        return employeRepo.findAll();

    }

    public Employe findByNik(String nik) {
        return employeRepo.findByNik(nik);
    }


    public static void main(String[] args) {

        Employe employe = new Employe();

        System.out.println(employe.getTanggal());

    }


}



