package com.example.springboot.Exercise6.repository;

import com.example.springboot.Exercise6.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepo extends JpaRepository<Meal, Long> {

    List<Meal> findByIsSummerMeal(Boolean isSummerMeal);

    List<Meal> findByIsWinterMeal(Boolean isWinterMeal);

}

