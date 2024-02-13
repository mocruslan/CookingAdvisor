package com.mocruc.cookingadvisor.service;

import com.mocruc.cookingadvisor.entity.Recipe;
import com.mocruc.cookingadvisor.exception.recipe.RecipeIdMismatchException;
import com.mocruc.cookingadvisor.exception.recipe.RecipeNotFoundException;
import com.mocruc.cookingadvisor.repository.iRecipeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final iRecipeCrudRepository recipeCrudRepository;

    @Autowired
    public RecipeService(iRecipeCrudRepository recipeCrudRepository) {
        this.recipeCrudRepository = recipeCrudRepository;
    }

    public Iterable<Recipe> getAllRecipes() {
        return recipeCrudRepository.findAll();
    }

    public Recipe getRecipeById(long id) {
        return recipeCrudRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found"));
    }

    public Recipe createRecipe(Recipe recipe) {
        return (Recipe) recipeCrudRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe, long id) {
        if (recipe.getId() != id) {
            throw new RecipeIdMismatchException("ID mismatch");
        }

        recipeCrudRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found"));
        return (Recipe) recipeCrudRepository.save(recipe);
    }

    public void deleteRecipe(long id) {
        recipeCrudRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found"));

        recipeCrudRepository.deleteById(id);
    }
}
