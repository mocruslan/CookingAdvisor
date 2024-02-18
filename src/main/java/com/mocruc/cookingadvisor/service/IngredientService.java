package com.mocruc.cookingadvisor.service;

import com.mocruc.cookingadvisor.entity.Ingredient;
import com.mocruc.cookingadvisor.exception.ingredient.IngredientNotFoundException;
import com.mocruc.cookingadvisor.repository.iIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredientService {
    private final iIngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(iIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Transactional(readOnly = true)
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Ingredient getIngredientById(long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException("Ingredient not found"));
    }

    @Transactional
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Transactional
    public Ingredient updateIngredient(Ingredient ingredient, long id) {
        if (ingredient.getId() != id) {
            throw new IngredientNotFoundException("ID mismatch");
        }

        ingredientRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException("Ingredient not found"));
        return ingredientRepository.save(ingredient);
    }

    @Transactional
    public void deleteIngredient(long id) {
        ingredientRepository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException("Ingredient not found"));

        ingredientRepository.deleteById(id);
    }
}
