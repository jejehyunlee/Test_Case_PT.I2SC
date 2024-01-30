package com.SimpleCrud.WebApp.controlers;

import java.time.LocalDate;
import java.util.List;

// import javax.validation.Valid;

import com.SimpleCrud.WebApp.models.Employe;
import com.SimpleCrud.WebApp.utils.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SimpleCrud.WebApp.dto.searchdata;
import com.SimpleCrud.WebApp.services.EmployeService;

@Controller
@RequestMapping
public class EmployeController {

    @Autowired
    public EmployeService employeService;

    Country country = new Country();

    @GetMapping
    public String welcome(Model model){
        String message = "Aplikasi Data Karyawan";
//        Employe employe = new Employe();
//
//        LocalDate today = LocalDate.now();
//
//        LocalDate birthdate = employe.getTanggal() ;
//
//        int age = today.compareTo(birthdate);

        model.addAttribute("msg", message);
        model.addAttribute("searchForm", new searchdata());
        model.addAttribute("products", employeService.findAll());
//        model.addAttribute("age", age);
////        System.out.println(age);
        return "index" ;
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("pilihnegara", List.of(country.countries));
        model.addAttribute("products", new Employe());
        return "add";

    }

    @PostMapping(value = "/save")
    public String save(RedirectAttributes attributes, Employe employe) {
        Employe dataEmployee = employeService.findByNik(employe.getNik());

        if (dataEmployee == null) {
            employeService.addEmployee(employe);
            attributes.addFlashAttribute("alert", "Data berhasil disimpan!");
            return "redirect:/";
        } else {
            attributes.addFlashAttribute("already", "Uuuppsss.....! No. Registrasi Sudah terdaftar");
            return "redirect:/add";
        }
    }

    @GetMapping(value = "/delete/{Id}")
    public String delete(@PathVariable("Id") long Id) {
        employeService.deletById(Id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{Id}")
    public String edit(@PathVariable("Id") long Id, Model model) {
        model.addAttribute("pilihnegara", List.of(country.countries));
        model.addAttribute("products", employeService.findById(Id));
        return "edit";
    }

    @GetMapping(value = "/detail/{Id}")
    public String detail(@PathVariable("Id") long Id, Model model) {
        model.addAttribute("products", employeService.findById(Id));
        return "detail";
    }

    @PostMapping(value = "/update")
    public String update(RedirectAttributes attributes, Employe employe, Model model) {
        employeService.updateEmployee(employe);
        attributes.addFlashAttribute("alertedit", "Data berhasil di ubah!");
        return "redirect:/";

    }

//    @GetMapping(value = "/detail")
//    public String detail(Model model) {
//        String message = "Aplikasi Data Kendaraan";
//        model.addAttribute("msg", message);
//        model.addAttribute("Products", pService.findAll());
//        return "detail";
//    }

    @PostMapping("/search")
    public String search(RedirectAttributes attributes, searchdata srcdata, Model model, String keyword,
            Employe employe) {
        Employe dbproduct = employeService.findByNik(keyword);
        if (dbproduct != null) {
            String message = "Aplikasi Data Kendaraan";
            model.addAttribute("msg", message);
            model.addAttribute("searchForm", srcdata);
            model.addAttribute("products", employeService.FindByNik(srcdata.getKeyword()));
            return "index";
        } else {
            attributes.addFlashAttribute("notfound", "Data tidak ada");
            return "redirect:/";
        }
    }

}
