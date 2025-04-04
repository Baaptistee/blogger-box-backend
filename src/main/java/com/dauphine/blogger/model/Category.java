package com.dauphine.blogger.model;

import java.util.UUID;

public class Category {
    private UUID id;
    private String name;

    public Category(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Category category = (Category) obj;

        return id != null ? id.equals(category.id) : category.id == null;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
