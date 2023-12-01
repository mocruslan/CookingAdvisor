package com.mocruc.cookingadvisor.database;

import com.mocruc.cookingadvisor.entity.Recipe;
import com.mocruc.cookingadvisor.repository.iRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final iRecipeRepository repository;

    @Autowired
    public DatabaseLoader(iRecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new Recipe("Spaghetti", "Spaghetti with tomato sauce"));
    }
}
