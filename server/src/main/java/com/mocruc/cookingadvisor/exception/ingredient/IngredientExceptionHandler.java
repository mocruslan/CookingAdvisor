package com.mocruc.cookingadvisor.exception.ingredient;

import com.mocruc.cookingadvisor.exception.recipe.RecipeNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class IngredientExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({IngredientNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(
                ex,
                "Ingredient not found",
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request
        );
    }
}
