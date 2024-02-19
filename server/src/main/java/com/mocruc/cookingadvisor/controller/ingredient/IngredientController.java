package com.mocruc.cookingadvisor.controller.ingredient;

import com.mocruc.cookingadvisor.entity.Ingredient;
import com.mocruc.cookingadvisor.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;
    private final IngredientModelAssembler assembler;

    @Autowired
    public IngredientController(IngredientService ingredientService, IngredientModelAssembler assembler) {
        this.ingredientService = ingredientService;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Ingredient>> getAllIngredients() {
        return this.assembler.toCollectionModel(ingredientService.getAllIngredients());
    }

    @GetMapping("/{id}")
    public EntityModel<Ingredient> getIngredientById(@PathVariable Long id) {
        return this.assembler.toModel(ingredientService.getIngredientById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntityModel<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        return this.assembler.toModel(ingredientService.createIngredient(ingredient));
    }

    @PutMapping("/{id}")
    public EntityModel<Ingredient> updateIngredient(@RequestBody Ingredient ingredient, @PathVariable Long id) {
        return this.assembler.toModel(ingredientService.updateIngredient(ingredient, id));
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
    }
}
