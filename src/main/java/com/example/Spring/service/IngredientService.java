package com.example.Spring.service;

import com.example.Spring.dao.IngredientDao;
import com.example.Spring.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private IngredientDao ingredientDao;
    @Autowired
    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void addIngredient(Ingredient i){
        if(i == null) throw new IllegalArgumentException("Ingredient cannot be null!");
        if(i.getName() == null || i.getName().isEmpty()) throw new IllegalArgumentException("Ingredient name cannot be null or empty!");
        ingredientDao.addIngredient(i);
    }

    public void deleteIngredient (String ingName){
        ingredientDao.deleteIngredient(ingName);
    }

    public void updateIngredient(Ingredient i){
        ingredientDao.updateIngredient(i);
    }

    public List<Ingredient> getIngredientList(){
        return ingredientDao.getIngredientList();
    }}
