package com.example.springboot.Exercise6.services;

import com.example.springboot.Exercise6.entity.Ingredient;
import com.example.springboot.Exercise6.repository.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    public IngredientRepo iRepo;

    public void insertIngredientTest(Ingredient i){
        iRepo.save(i);
    }

    public List<Ingredient> getAllIngredient(){
        return iRepo.findAll();
    }

    public Optional<Ingredient> getIngredient(Long id){
        return iRepo.findById(id);
    }

    public void updateIngredient(Ingredient i){
        iRepo.deleteById(i.getId());
        iRepo.save(i);
    }

    public void deleteIngredient(Long id){
        iRepo.deleteById(id);
    }
}
