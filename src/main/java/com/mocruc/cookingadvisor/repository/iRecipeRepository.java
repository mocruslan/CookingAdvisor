package com.mocruc.cookingadvisor.repository;

import com.mocruc.cookingadvisor.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface iRecipeRepository extends CrudRepository<Recipe, Long> {
}
