package com.example.springboot.Exsercise5.repository;

import com.example.springboot.Exsercise5.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
}
