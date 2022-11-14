package com.SimpleCrud.WebApp.controlers;

import java.util.List;

// import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SimpleCrud.WebApp.dto.searchdata;
import com.SimpleCrud.WebApp.models.Product;
import com.SimpleCrud.WebApp.services.ProductService;
// import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;



@Controller
@RequestMapping
public class HomeController {

    @Autowired
    public ProductService pService;

    @GetMapping
    public String welcome(searchdata srcdata, Model model) {
        String message = "Aplikasi Data Kendaraan";
        model.addAttribute("msg", message);
        model.addAttribute("searchForm", new searchdata());
        model.addAttribute("products", pService.findAll());
        return "index";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("pilihwarna", List.of("Black-Matte", "Red-Matte", "White-Pearl"));
        model.addAttribute("Productse", new Product());
        return "add";

    }

    @PostMapping(value = "/save")
    public String save(RedirectAttributes attributes, Product product, Model model) {
        Product dbproduct = pService.findByNoreg(product.getNoreg());

        if (dbproduct == null) {
            pService.addProduct(product);
            attributes.addFlashAttribute("alert", "Data berhasil disimpan!");
            return "redirect:/";
        } else {
            attributes.addFlashAttribute("already", "Uuuppsss.....! No. Registrasi Sudah terdaftar");
            return "redirect:/add";
        }
    }

    @GetMapping(value = "/delete/{Id}")
    public String delete(@PathVariable("Id") long Id) {
        pService.deletById(Id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{Id}")
    public String edit(@PathVariable("Id")long Id, Model model) {
        model.addAttribute("pilihwarna", List.of("Black-Matte", "Red-Matte", "White-Pearl"));
        model.addAttribute("products", pService.findById(Id));
        return "edit";
    }

    @GetMapping(value = "/detail/{Id}")
    public String detail(@PathVariable("Id") long Id, Model model) {
        model.addAttribute("produk", pService.findById(Id));
        return "detail";
    }

    @PostMapping(value = "/update")
    public String update(RedirectAttributes attributes, Product product, Model model) {
        pService.updateProduct(product);
        attributes.addFlashAttribute("alertedit", "Data berhasil di ubah!");
        return "redirect:/";

    }

    @GetMapping(value = "/detail")
    public String detail(Model model) {
        String message = "Aplikasi Data Kendaraan";
        model.addAttribute("msg", message);
        model.addAttribute("products", pService.findAll());
        return "detail";
    }

    @PostMapping("/search")
    public String search(RedirectAttributes attributes, searchdata srcdata, Model model, String keyword,Product product) {
        Product dbproduct = pService.findByNama(keyword);
        if (dbproduct != null) {
            String message = "Aplikasi Data Kendaraan";
            model.addAttribute("msg", message);
            model.addAttribute("searchForm", srcdata);
            model.addAttribute("products", pService.FindByName(srcdata.getKeyword()));
            return "index";
        } else  {
            attributes.addFlashAttribute("notfound", "Uuuppsss.....! Nama tidak ditemukan");
            return "redirect:/";

        }
    }

}
