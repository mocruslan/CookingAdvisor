package com.mocruc.cookingadvisor.controller.recipe;

import com.mocruc.cookingadvisor.entity.Recipe;
import com.mocruc.cookingadvisor.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeModelAssembler assembler;

    @Autowired
    public RecipeController(RecipeService recipeService, RecipeModelAssembler assembler) {
        this.recipeService = recipeService;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Recipe>> getAllRecipes() {
        return this.assembler.toCollectionModel(recipeService.getAllRecipes());
    }

    @GetMapping("/{id}")
    public EntityModel<Recipe> getRecipeById(@PathVariable Long id) {
        return this.assembler.toModel(recipeService.getRecipeById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<?> createRecipe(@RequestBody Recipe recipe) {
        return this.assembler.toModel(recipeService.createRecipe(recipe));
    }

    @PutMapping("/{id}")
    public EntityModel<?> updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) {
        return this.assembler.toModel(recipeService.updateRecipe(recipe, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);

        return ResponseEntity.noContent().build();
    }
}
