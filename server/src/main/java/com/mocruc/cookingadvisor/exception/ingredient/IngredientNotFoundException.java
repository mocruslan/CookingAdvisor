package com.mocruc.cookingadvisor.exception.ingredient;

public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(String message) {
        super(message);
    }
}
