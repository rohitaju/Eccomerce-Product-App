package com.example.EcommerceWebsite.Controller;

import com.example.EcommerceWebsite.Model.Product;
import com.example.EcommerceWebsite.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/add/product")
    public String addProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/admin/home";
    }

    @GetMapping("/update/product/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "UpdateProduct";
    }

    @PostMapping("/update/product")
    public String updateProduct(@ModelAttribute Product product) {
        productService.createProduct(product);
        return "redirect:/admin/home";
    }



    @GetMapping("/delete/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/home";
    }


    @GetMapping("/product/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product" ,  product);
        return "apply"; // Renders apply.html
    }

    @PostMapping("/apply/{id}")
    public String applyForProduct(@PathVariable Long id,
                              @RequestParam String userName,
                              @RequestParam String userEmail,
                              @RequestParam String userResume,
                              RedirectAttributes redirectAttributes) {

        // Save the application data to DB (optional)
        System.out.println("User " + userName + " applied for Product ID " + id);

        redirectAttributes.addFlashAttribute("success", "Application submitted successfully!");
        return "redirect:/product";
    }

}
