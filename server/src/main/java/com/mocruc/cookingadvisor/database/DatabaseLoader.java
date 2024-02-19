//package com.mocruc.cookingadvisor.database;
//
//import com.mocruc.cookingadvisor.entity.Recipe;
//import com.mocruc.cookingadvisor.repository.iRecipeCrudRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DatabaseLoader implements CommandLineRunner {
//    private final iRecipeCrudRepository repository;
//
//    @Autowired
//    public DatabaseLoader(iRecipeCrudRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        this.repository.save(new Recipe("Spaghetti", "Spaghetti with tomato sauce"));
//        this.repository.save(new Recipe("Spaghetti2", "Spaghetti with tomato sauce"));
//        this.repository.save(new Recipe("Spaghetti3", "Spaghetti with tomato sauce"));
//        this.repository.save(new Recipe("Spaghetti4", "Spaghetti with tomato sauce"));
//    }
//}
