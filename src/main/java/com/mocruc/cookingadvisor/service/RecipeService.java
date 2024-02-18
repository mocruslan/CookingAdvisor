package com.mocruc.cookingadvisor.service;

import com.mocruc.cookingadvisor.entity.Recipe;
import com.mocruc.cookingadvisor.exception.recipe.RecipeIdMismatchException;
import com.mocruc.cookingadvisor.exception.recipe.RecipeNotFoundException;
import com.mocruc.cookingadvisor.repository.iRecipeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeService {
    private final iRecipeCrudRepository recipeCrudRepository;

    @Autowired
    public RecipeService(iRecipeCrudRepository recipeCrudRepository) {
        this.recipeCrudRepository = recipeCrudRepository;
    }

    @Transactional(readOnly = true)
    public Iterable<Recipe> getAllRecipes() {
        return recipeCrudRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Recipe getRecipeById(long id) {
        return recipeCrudRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found"));
    }

    @Transactional
    public Recipe createRecipe(Recipe recipe) {
        return recipeCrudRepository.save(recipe);
    }

    @Transactional
    public Recipe updateRecipe(Recipe recipe, long id) {
        if (recipe.getId() != id) {
            throw new RecipeIdMismatchException("ID mismatch");
        }

        recipeCrudRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found"));
        return (Recipe) recipeCrudRepository.save(recipe);
    }

    @Transactional
    public void deleteRecipe(long id) {
        recipeCrudRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found"));

        recipeCrudRepository.deleteById(id);
    }
}
