package com.dauphine.blogger.service;

import com.dauphine.blogger.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();

    Category getById(UUID id);

    Category create(String name, UUID categoryId);

    Category update(UUID id, String name);

    boolean deleteById(UUID id);
}
