package com.example.Spring.service;

import com.example.Spring.Meal;
import com.example.Spring.dao.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private MealDao mealDao;

    @Autowired
    public MealService(MealDao mealDao){
        this.mealDao = mealDao;
    }
    public void addMeal(Meal meal){
        if (meal == null) throw new IllegalArgumentException("Meal can't be null");
        if (meal.getName() == null || meal.getName().isEmpty()) throw new IllegalArgumentException("Meal name can't be null or empty");
        if (meal.getDescription() == null || meal.getDescription().isEmpty()) throw new IllegalArgumentException("Meal description can't be null or empty");
        if (meal.getPrice() <= 0) throw new IllegalArgumentException("Meal price can't be less or equal to 0");
        mealDao.addMeal(meal);
    }

    public void deleteMeal (String mealName){
        if (mealName == null) throw new IllegalArgumentException("Can't delete something that doesn't exist");
        mealDao.deleteMeal(mealName);
    }

    public void updateMeal (Meal meal){
        mealDao.updateMeal(meal);
    }

    public List<Meal> getMeals(){
        return mealDao.getMeals();
    }
}
