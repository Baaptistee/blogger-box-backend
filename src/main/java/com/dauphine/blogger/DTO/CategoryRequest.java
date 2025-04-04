package com.dauphine.blogger.DTO;

import java.util.UUID;

public class CategoryRequest {
    private String name;
    private String description;
    private UUID id;


    public CategoryRequest() {
    }

    public CategoryRequest(String name, String description, UUID id) {
        this.name = name;
        this.description = description;
        this.id = id;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}


