package com.example.springboot.Exercise6.controllers;

import com.example.springboot.Exercise6.entity.Meal;
import com.example.springboot.Exercise6.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise6")
public class MealController {
    @Autowired
    private MealService mealService;

    @PostMapping("/insert-meals")
    public ResponseEntity<?> putMeal(@RequestBody Meal meal){
        mealService.insertMealTest();
        return ResponseEntity.ok("meal added");
    }

    @GetMapping("/get-meal/{id}")
    public ResponseEntity<?> getMeal(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(mealService.getMeal(id));
    }

    @GetMapping("/summer-meals")
    public ResponseEntity<List<Meal>> getSummerMeals(){
        return ResponseEntity.ok(mealService.getSummerMeals());
    }

    @GetMapping("/winter-meals")
    public ResponseEntity<List<Meal>> getWinterMeals(){
        return ResponseEntity.ok(mealService.getWinterMeal());
    }

}
