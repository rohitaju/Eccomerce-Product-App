
package com.example.EcommerceWebsite.Controller;


import com.example.EcommerceWebsite.Model.Admin;
import com.example.EcommerceWebsite.Model.Product;
import com.example.EcommerceWebsite.Service.AdminService;
import com.example.EcommerceWebsite.Service.ProductService;
import com.example.EcommerceWebsite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller

public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;


    @Autowired
    private ProductService productService;


    @GetMapping("/admin/home")
    public String adminHomePage(Model model) {
        model.addAttribute("adminList", adminService.getAllAdmin());
        model.addAttribute("userList", userService.getAllUser());
        model.addAttribute("productList", productService.getAllProduct());

        model.addAttribute("product", new Product());


        return "AdminHomePage";
    }

    @PostMapping("/add/admin")
    public String createAdmin(Admin admin) {
        adminService.createUser(admin);

        return "redirect:/admin/home";
    }

    @GetMapping("/update/admin/{id}")
    public String update(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("admin", adminService.getAdminById(id));
        return "UpdateAdmin";
    }

    @PostMapping("/update/admin")
    public String updateAdmin(@ModelAttribute("admin") Admin admin) {
        adminService.updateAdmin(admin); // Make sure this saves changes
        return "redirect:/admin/home";
    }

    @GetMapping("/delete/admin/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);

        return "redirect:/admin/home";
    }


}