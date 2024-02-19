package com.mocruc.cookingadvisor.exception.recipe;

public class RecipeIdMismatchException extends RuntimeException {
    public RecipeIdMismatchException(String message) {
        super(message);
    }
}
