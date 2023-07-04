package com.example.springboot.Exercise5.repository;

import com.example.springboot.Exercise5.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepo extends JpaRepository<Meal, Long> {

}

