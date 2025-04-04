package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();

    Category getById(UUID id);

    List<Category> getByName(String name);

    Category create(String name);

    Category update(UUID id, String name);

    boolean deleteById(UUID id);
}
