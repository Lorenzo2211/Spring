package com.example.Spring.controller;

import com.example.Spring.service.IngredientService;
import com.example.Spring.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService IngredientService) {
        this.ingredientService = IngredientService;
    }

    @GetMapping("/get/Ingredients")
    public ResponseEntity<List<Ingredient>> index(){
        return ResponseEntity.ok(ingredientService.getIngredientList());
    }
    @GetMapping("/put/Ingredient")
    public ResponseEntity<String> putItem(@RequestBody Ingredient Ingredient){
        try{
            ingredientService.addIngredient(Ingredient);
            return ResponseEntity.ok("Ingredient added!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/Ingredient/{IngredientName}")
    public ResponseEntity<String> deleteIngredient(@PathVariable String IngredientName){
        ingredientService.deleteIngredient(IngredientName);
        return ResponseEntity.ok("Ingredient deleted!");
    }
}
