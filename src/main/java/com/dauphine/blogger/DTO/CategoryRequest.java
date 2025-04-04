package com.dauphine.blogger.DTO;

import java.util.UUID;

public class CategoryRequest {
    private String name;
    private UUID id;


    public CategoryRequest() {
    }

    public CategoryRequest(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}


