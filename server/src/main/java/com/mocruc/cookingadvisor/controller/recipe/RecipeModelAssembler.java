package com.mocruc.cookingadvisor.controller.recipe;

import com.mocruc.cookingadvisor.entity.Recipe;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RecipeModelAssembler implements RepresentationModelAssembler<Recipe, EntityModel<Recipe>> {
    @Override
    public EntityModel<Recipe> toModel(Recipe entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(RecipeController.class).getRecipeById(entity.getId())).withSelfRel(),
                linkTo(methodOn(RecipeController.class).getAllRecipes()).withRel("recipes")
        );
    }

    @Override
    public CollectionModel<EntityModel<Recipe>> toCollectionModel(Iterable<? extends Recipe> entities) {
        List<EntityModel<Recipe>> recipes = new ArrayList<>();

        for (Recipe recipe : entities) {
            recipes.add(this.toModel(recipe));
        }

        return CollectionModel.of(
                recipes,
                linkTo(methodOn(RecipeController.class).getAllRecipes()).withSelfRel()
        );
    }
}
