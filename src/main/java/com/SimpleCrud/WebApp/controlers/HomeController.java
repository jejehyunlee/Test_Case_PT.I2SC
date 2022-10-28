package com.SimpleCrud.WebApp.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.SimpleCrud.WebApp.models.Product;
import com.SimpleCrud.WebApp.services.ProductService;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    public ProductService pService;

    @GetMapping
    public String welcome(Model model) {
        String message = "Aplikasi Data Kendaraan";
        model.addAttribute("msg", message);
        model.addAttribute("products", pService.findAll());
        return "index";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("Productse", new Product());
        return "add";
    }

    @PostMapping(value = "/save")
    public String save(Product product, Model model) {
        pService.addProduct(product);
        return "redirect:/";

    }

    @GetMapping(value = "/delete/{Id}")
    public String delete(@PathVariable("Id") long Id) {
        pService.deletById(Id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{Id}")
    public String edit(@PathVariable("Id") long Id, Model model) {
        model.addAttribute("products", pService.findById(Id));
        return "edit";
    }

    @PostMapping(value = "/update")
    public String update(Product product, Model model) {
        pService.updateProduct(product);
        return "redirect:/";

    }

    @GetMapping(value = "/detail")
    public String detail(Model model) {
        String message = "Aplikasi Data Kendaraan";
        model.addAttribute("msg", message);
        model.addAttribute("products", pService.findAll());
        return "detail";
    }


}
