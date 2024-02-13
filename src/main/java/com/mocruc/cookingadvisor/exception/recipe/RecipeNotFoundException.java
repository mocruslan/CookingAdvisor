package com.mocruc.cookingadvisor.exception.recipe;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(String message) {
        super(message);
    }
}
