package com.example.springboot.Exercise4.controllers;

import com.example.springboot.Exercise4.models.Meal;
import com.example.springboot.Exercise4.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercise4")
public class MealController {
    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/get/meals")
    public ResponseEntity<?> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping("/put/meals")
    public ResponseEntity<?> putMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
        return ResponseEntity.ok("meal added");
    }

    @DeleteMapping("/delete/meal/{mealName}")
    public ResponseEntity<?> deleteMeal(@PathVariable String mealName){
        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted");
    }
}
