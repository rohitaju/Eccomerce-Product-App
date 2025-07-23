package com.example.EcommerceWebsite.Repository;



import com.example.EcommerceWebsite.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;






public interface UserRepo extends JpaRepository<User, Long>{
    public User findByEmail(String email);
}

