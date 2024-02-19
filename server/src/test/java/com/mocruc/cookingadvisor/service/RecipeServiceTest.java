package com.mocruc.cookingadvisor.service;

import com.mocruc.cookingadvisor.entity.Recipe;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceTest {
    private static final String API_ROOT
            = "http://localhost:8080/api/recipes";

    private Recipe createRandomBook() {
        return new Recipe(randomAlphabetic(10, 15), randomAlphabetic(15, 20));
    }

    private String createBookAsUri(Recipe recipe) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(recipe)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    @Test
    public void testGetAllRecipes() {
        Response response = RestAssured.get(API_ROOT);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void testCreateRecipe() {
        Recipe recipe = createRandomBook();
        String location = createBookAsUri(recipe);

        Response response = RestAssured.post(location);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
        assertEquals(recipe.getName(), response.jsonPath()
                .get("name"));
        assertEquals(recipe.getDescription(), response.jsonPath()
                .get("description"));
    }

    @Test
    public void testGetRecipeById() {
        Recipe recipe = createRandomBook();
        String location = createBookAsUri(recipe);

        Response response = RestAssured.get(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        assertEquals(recipe.getName(), response.jsonPath()
                .get("name"));
        assertEquals(recipe.getDescription(), response.jsonPath()
                .get("description"));
    }

    @Test
    public void testDeleteRecipe() {
        Recipe recipe = createRandomBook();
        String location = createBookAsUri(recipe);

        Response response = RestAssured.delete(location);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode());

        response = RestAssured.get(location);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
}