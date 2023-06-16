package com.example.springboot.Exercise2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/esercizio2")
public class MealController {
    List<Meal> pastiDelloChef = Arrays.asList(
            new Meal("Pizza", "pasta per pizza, salsa di pomodoro, mozzarella", 5.99),
            new Meal("Pasta alla Carbonara", "Spaghetti, uova, guanciale, pecorino romano, pepe nero", 12.99),
            new Meal("Fiorentina", "bistecca di vitello alla griglia cotta al sangue", 39.99)
    );

    // Exercise 1: Create a GetMapping that returns a list of meals
    //
    //1 - Annotate a new class with the @RestController annotation. 2 - Create a new endpoint "/meals" using the @GetMapping annotation.
    // 3 - In the method, return a list of Meal objects.
    //
    @GetMapping("/pasti")
    public List<Meal> getPastiDelloChef(){
        return pastiDelloChef;
    }

    //Exercise 2: Create a GetMapping that returns a meal by name
    //
    //1 - Annotate a new class with the @RestController annotation. 2 - Create a new endpoint "/meal/{name}" using the @GetMapping annotation.
    // 3 - In the method, add a query parameter "name" using the @PathVariable annotation. 4 - Return a Meal object with the corresponding name.

    @GetMapping("/pasti-per-nome/{name}")
    public ResponseEntity<?> getPastiDelloChefNome(@PathVariable("name") String name){

//                return ResponseEntity.ok(pastiDelloChef.stream().filter(meal -> meal.getName().contains(name)).findFirst().orElse(null));
        Meal m = null;
        for (Meal s : pastiDelloChef){
            if (s.getName().contains(name)){
                m = s;
            }
        }
        
        if (m == null){
            return ResponseEntity.badRequest().body("lista vuota");
        }else {
            return ResponseEntity.ok(m);
        }
    }

    //Exercise 3: Create a GetMapping that returns a meal by any word of description
    //
    //1 - Annotate a new class with the @RestController annotation. 2 - Create a new endpoint "/meal/description-match/{phrase}" using the @GetMapping annotation.
    //3 - In the method, add a query parameter "description" using the @PathVariable annotation. 4 - Return a Meal object with the corresponding description.

    @GetMapping("/meal/description-match/{phrase}")
    public ResponseEntity<?> description(@PathVariable("phrase") String phrase){

//        return ResponseEntity.ok(pastiDelloChef.stream().filter(meal -> meal.getDescription().contains(phrase)).findFirst().orElse(null));

        Meal m = null;
        for (Meal s : pastiDelloChef){
            if (s.getDescription().contains(phrase)){
                m = s;
            }
        }

        if (m == null){
            return ResponseEntity.badRequest().body("lista vuota");
        }else {
            return ResponseEntity.ok(m);
        }

    }


//Exercise 4: Create a GetMapping that returns a meal by price range
//
//        1 - Annotate a new class with the @RestController annotation. 2 - Create a new endpoint "/meal/price" using the @GetMapping annotation.
//        3 - In the method, add two query parameters "min" and "max" using the @RequestParam annotation. 4 - Return a list of Meal objects with prices within the specified range.

    @GetMapping("meal/price-range/")
    public ResponseEntity<?> getMaxAndMinPrice(@RequestParam("min") Double min,
                                               @RequestParam("max") Double max){

        List<Meal> m = new ArrayList<>();

        for (Meal s : pastiDelloChef){
            if (s.getPrice()>= min && s.getPrice() <= max){
                m.add(s);
            }
        }

        if (m == null){
            return ResponseEntity.badRequest().body("lista vuota");
        }else {
            return ResponseEntity.ok(m);
        }

    }

}
