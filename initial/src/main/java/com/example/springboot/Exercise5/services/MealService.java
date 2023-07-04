package com.example.springboot.Exercise5.services;


import com.example.springboot.Exercise5.repository.MealRepo;
import com.example.springboot.Exercise5.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {
    @Autowired
    public MealRepo mealRepo;

    public void insertMealTest(){
        mealRepo.save(new Meal("Test meal", "Very tasty", 4.8));
    }


}

