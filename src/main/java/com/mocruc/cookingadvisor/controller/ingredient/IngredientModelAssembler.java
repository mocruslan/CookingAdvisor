package com.mocruc.cookingadvisor.controller.ingredient;

import com.mocruc.cookingadvisor.entity.Ingredient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IngredientModelAssembler implements RepresentationModelAssembler<Ingredient, EntityModel<Ingredient>> {
    @Override
    public EntityModel<Ingredient> toModel(Ingredient entity) {
        return EntityModel.of(
                entity,
                linkTo(methodOn(IngredientController.class).getIngredientById(entity.getId())).withSelfRel(),
                linkTo(methodOn(IngredientController.class).getAllIngredients()).withRel("ingredients")
        );
    }

    @Override
    public CollectionModel<EntityModel<Ingredient>> toCollectionModel(Iterable<? extends Ingredient> entities) {
        List<EntityModel<Ingredient>> ingredients = new ArrayList<>();

        for (Ingredient ingredient : entities) {
            ingredients.add(this.toModel(ingredient));
        }

        return CollectionModel.of(
                ingredients,
                linkTo(methodOn(IngredientController.class).getAllIngredients()).withSelfRel()
        );
    }
}
