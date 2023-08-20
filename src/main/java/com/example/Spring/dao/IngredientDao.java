package com.example.Spring.dao;

import com.example.Spring.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientDao {
    List<Ingredient> ingredientList = new ArrayList<>();

    public void addIngredient(Ingredient i){
        this.ingredientList.add(i);
    }

    public void deleteIngredient(String ingName){
        this.ingredientList.removeIf(i -> i.getName().equals(ingName));
    }

    public void updateIngredient(Ingredient i){
        this.ingredientList.removeIf(in -> in.getName().equals(i.getName()));
        this.ingredientList.add(i);
    }

    public List<Ingredient> getIngredientList(){
        return this.ingredientList;
    }
}
