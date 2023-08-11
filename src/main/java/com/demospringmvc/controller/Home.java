package com.demospringmvc.controller;

import com.demospringmvc.model.Product;
import com.demospringmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/products")
public class Home {
    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView home(Model model){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.products);
        return modelAndView;
    }
    @GetMapping("/{id}")
    public String showEdit2(Model model, @PathVariable int id){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product){
        productService.edit(product);
        return "redirect:/products";
    }

    public String home(){
        return "home";
    }
}
