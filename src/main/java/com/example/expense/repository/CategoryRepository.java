package com.example.expense.repository;

import com.example.expense.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Spring data JPA provides implementation for this interface
    // CRUD methods to perform CRUD database operations on Category entity
    // Spring Data JPA provides transaction for all the CRUD methods
}
