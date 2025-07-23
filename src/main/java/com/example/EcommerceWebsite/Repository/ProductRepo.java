package com.example.EcommerceWebsite.Repository;


import com.example.EcommerceWebsite.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Long> {
}
