package com.example.EcommerceWebsite.Service;



import java.util.List;


import com.example.EcommerceWebsite.Model.Product;
import com.example.EcommerceWebsite.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService {

    @Autowired
    private ProductRepo  productRepo;

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
    }

    public void createProduct(Product product) {
        productRepo.save(product);
    }

    public void updateProduct(Product product) {
        productRepo.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product with id " + product.getId() + " not found"));
        productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
        productRepo.deleteById(id);
    }



}