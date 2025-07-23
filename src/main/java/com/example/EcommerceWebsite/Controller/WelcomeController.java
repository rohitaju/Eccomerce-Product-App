package com.example.EcommerceWebsite.Controller;


import java.util.List;

import com.example.EcommerceWebsite.Model.Product;


import com.example.EcommerceWebsite.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String welcome(Model model) {
        List<Product> product = productService.getAllProduct();  // Fetch all jobs
        model.addAttribute("productList",product);

        return "product.html";
    }

    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "AboutUs";
    }

    @GetMapping("/contactUs")
    public String contactUs() {
        return "ContactUs";
    }

    @GetMapping("/home")
    public String home() {
        return "welcome";
    }




}
