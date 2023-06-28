package com.example.springboot.Exsercise5.controllers;

import com.example.springboot.Exsercise5.entity.Meal;
import com.example.springboot.Exsercise5.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercise5")
public class MealController {
    @Autowired
    private MealService mealService;

    @PostMapping("/insert-meals")
    public ResponseEntity<?> putMeal(@RequestBody Meal meal){
        mealService.insertMealTest();
        return ResponseEntity.ok("meal added");
    }

}
