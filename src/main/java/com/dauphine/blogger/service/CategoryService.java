package com.dauphine.blogger.service;

import com.dauphine.blogger.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();

    Category getById(UUID id);

    Category create(String name, String description, UUID categoryId);

    Category update(UUID id, String name, String description);

    boolean deleteById(UUID id);
}
