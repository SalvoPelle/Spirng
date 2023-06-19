package com.example.springboot.Exercise3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/esercizio3")
public class MealController {
    private List<Meal> pastiDelloChef = new ArrayList<>();
    @GetMapping("/pasti")
    public List<Meal> getPastiDelloChef(){
        return pastiDelloChef;
    }

    //Exercise 1: Create a PutMapping to add a new meal
    //
    //1 - Create a new endpoint "/meal" using the @PostMapping annotation.
    // 3 - In the method, add a RequestBody for the new Meal object. 4 - Add the new meal to the list of meals.

    @PutMapping("/aggiungi-pasto")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        this.pastiDelloChef.add(meal);
        return ResponseEntity.ok("Pasto inserito");
    }

    //Exercise 2: Create a PostMapping to update a meal by name
    //
    //1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation. 2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
    // 3 - Update the meal with the corresponding name using the information from the RequestBody.
    @PostMapping("/modifica-pasto/{name}")
    public ResponseEntity<?> updateMeal(@PathVariable("name") String name,
            @RequestBody Meal meal){
//        this.pastiDelloChef.removeIf(m -> m.getName().equals(meal.getName()));
//        this.pastiDelloChef.add(meal);
        for (Meal s : pastiDelloChef){
            if (s.getName().equals(name)){
                pastiDelloChef.remove(s);
                pastiDelloChef.add(meal);
            }
        }

        return ResponseEntity.ok("Pasto aggiornato");
    }


    //Exercise 3: Create a DeleteMapping to delete a meal by name
    //
    //1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation. 2 - In the method, add a PathVariable for the name.
    // 3 - Delete the meal with the corresponding name.

    @DeleteMapping("/cancella-pasto/")
    public ResponseEntity<?> deleteMeal(@RequestParam("nome") String name){
//        this.pastiDelloChef.removeIf(m -> m.getName().equals(meal.getName()));
//        this.pastiDelloChef.add(meal);
        for (Meal s : pastiDelloChef){
            if (s.getName().equals(name)){
                pastiDelloChef.remove(s);
            }
        }

        return ResponseEntity.ok("Pasto cancellato");
    }

    //Exercise 4: Create a DeleteMapping to delete all meals above a certain price
    //
    //1 - Create a new endpoint "/meal/price/{price}" using the @DeleteMapping annotation. 2 - In the method, add a PathVariable for the price.
    // 3 - Delete all meals with a price above the price from the PathVariable.

    @DeleteMapping("/cancella-pasto-costoso/")
    public ResponseEntity<?> deleteMealPerPrice(@RequestParam("price") double price){
//        this.pastiDelloChef.removeIf(m -> m.getName().equals(meal.getName()));
//        this.pastiDelloChef.add(meal);
        for (Meal s : pastiDelloChef){
            if (s.getPrice()> price){
                pastiDelloChef.remove(s);
            }
        }

        return ResponseEntity.ok("Pasto cancellato");
    }

    //Exercise 5: Create a PutMapping to update the price of a meal by name
    //
    //1 - Create a new endpoint "/meal/{name}/price" using the @PutMapping annotation. 2 - In the method, add a PathVariable for the name and a RequestBody for the updated price.
    // 3 - Update the price of the meal with the corresponding name using the information from the RequestBody.
    @PostMapping("/meal/{name}/price")
    public ResponseEntity<?> updateByPrice(@PathVariable("name") String name, @RequestBody Meal meal){

        for (Meal s : pastiDelloChef) {
            if (s.getName().equals(name) && s.getDescription().equals(meal.getDescription()) && s.getPrice() != meal.getPrice()){
                pastiDelloChef.remove(s);
                pastiDelloChef.add(meal);
            }

        }

        return ResponseEntity.ok("Prezzo aggiornato");
    }
}
