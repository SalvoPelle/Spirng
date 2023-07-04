package com.example.springboot.Exercise5.controllers;

import com.example.springboot.Exercise5.entity.Ingredient;
import com.example.springboot.Exercise5.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise5")
public class IngredientController {

    @Autowired
    public IngredientService iService;

    @PostMapping("/insert-ingredient")
    public ResponseEntity<?> insertIngredient(@RequestBody Ingredient i){
        iService.insertIngredientTest(i);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all-ingredient")
    public List<Ingredient> getAllIngredient(){
        return iService.getAllIngredient();
    }

    @GetMapping("/get-ingredinet/{id}")
    public ResponseEntity<?> getIngredient(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(iService.getIngredient(id));
    }

    @PutMapping("/modify-user/{id}")
    public ResponseEntity<?> updateIngredient(@RequestBody Ingredient i, @PathVariable("id") Long id){
        iService.updateIngredient(i);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIngredient(@PathVariable("id") Long id){
        iService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }
}
