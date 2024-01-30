package com.SimpleCrud.WebApp.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        getAge(employe);
        employeRepo.save(employe);
    }

    public void deletById (long id){
        employeRepo.deleteById(id);
    }

    public Optional<Employe> findById(Long id) {
       return employeRepo.findById(id);
    }

    public void updateEmployee(Employe employe) {
        getAge(employe);
        employeRepo.save(employe);

    }
    
    public List<Employe> findByNameYaBro(String keyword) {
        if (keyword != null){
            return employeRepo.findByNamaContaining(keyword);
        }
        return employeRepo.findAll();
    }


    public List<Employe> findByNikYaBro(String keyword1, String keyword2) {
        if (keyword1 != null && keyword2 !=null){

            return employeRepo.findByNikOrNamaContaining(keyword1, keyword2);

        }
        return employeRepo.findAll();
    }

    public Employe findByNik(String nik) {
        return employeRepo.findByNik(nik);
    }



    public void getAge(Employe employe) {

        if (employe.getTanggal() != null) {
            LocalDate localDate = LocalDate.now();
            long years = ChronoUnit.YEARS.between(employe.getTanggal(), localDate);
            employe.setAge((int) years);
        }

    }

}



