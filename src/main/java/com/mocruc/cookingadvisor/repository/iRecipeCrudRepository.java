package com.mocruc.cookingadvisor.repository;

import com.mocruc.cookingadvisor.entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRecipeCrudRepository extends CrudRepository<Recipe, Long> {
}
