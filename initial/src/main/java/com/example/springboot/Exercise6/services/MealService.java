package com.example.springboot.Exercise6.services;


import com.example.springboot.Exercise6.entity.Meal;
import com.example.springboot.Exercise6.repository.MealRepo;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    public Double MIN_SUMMER_TEMP = 25.0;
    public Double MAX_WINTER_TEMP = 10.0;
    @Autowired
    public MealRepo mealRepo;


    public void insertMealTest(){
        mealRepo.save(new Meal("Test meal", "Very tasty", 4.8));
    }

    public Optional<Meal> getMeal(Long id){
        return mealRepo.findById(id);
    }

    public List<Meal> getSummerMeals(){
        Double currentTemperature = getCurrentTemperatureInSummer();
        if (currentTemperature < MIN_SUMMER_TEMP) {
            return new ArrayList<>();
        }else {
            return mealRepo.findByIsSummerMeal(true);
        }
    }

    public List<Meal> getWinterMeal(){
        Double currentTemperature = getCurrentTemperatureInWinter();
        if (currentTemperature > MAX_WINTER_TEMP){
            return new ArrayList<>();
        }else {
            return mealRepo.findByIsWinterMeal(true);
        }
    }

    /**
     *
     * metodo per ricevere risposta dalla API
     */
    private Double getCurrentTemperatureInSummer(){
        try {
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=37.4922&longitude=15.0704&current_weather=true").asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    private Double getCurrentTemperatureInWinter(){
        try {
            JSONObject response = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=71.2906&longitude=-156.7887&current_weather=true").asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}

