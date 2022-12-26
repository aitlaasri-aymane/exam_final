package com.example.inventoryservice.query.repositories;

import com.example.inventoryservice.query.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
    public Category findByName(String name);
}
