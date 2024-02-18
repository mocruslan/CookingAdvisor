package com.mocruc.cookingadvisor.repository;

import com.mocruc.cookingadvisor.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iIngredientRepository extends CrudRepository<Ingredient, Long> {
}
