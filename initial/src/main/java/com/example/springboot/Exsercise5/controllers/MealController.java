package com.example.springboot.Exsercise5.controllers;

import com.example.springboot.Exsercise5.models.Meal;
import com.example.springboot.Exsercise5.models.RestaurantConfig;
import com.example.springboot.Exsercise5.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercise4")
public class MealController {
    private MealService mealService;
    private RestaurantConfig restaurantConfig;

    @Autowired
    public MealController(MealService mealService, RestaurantConfig restaurantConfig) {
        this.mealService = mealService;
        this.restaurantConfig = restaurantConfig;
    }

    @GetMapping("/get/meals")
    public ResponseEntity<?> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @GetMapping
    public ResponseEntity<?> getRestaurantConfig() {
        return ResponseEntity.ok(restaurantConfig);
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
