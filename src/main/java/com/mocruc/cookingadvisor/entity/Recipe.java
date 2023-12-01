package com.mocruc.cookingadvisor.entity;

import jakarta.persistence.*;

@Entity
public class Recipe {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private String name;
    private String description;

    protected Recipe() {}

    public Recipe(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
