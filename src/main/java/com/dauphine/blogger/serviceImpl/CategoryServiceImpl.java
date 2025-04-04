package com.dauphine.blogger.serviceImpl;

import com.dauphine.blogger.model.Category;
import com.dauphine.blogger.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories;

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Category getById(UUID id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Category create(String name, String description, UUID categoryId) {
        Category category = new Category();
        category.setName(name);
        category.setId(UUID.randomUUID());
        category.setDescription(description);
        categories.add(category);
        return category;
    }

    @Override
    public Category update(UUID id, String name, String description) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                category.setName(name);
                category.setDescription(description);
                return category;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(UUID id) {
        return categories.removeIf(category -> category.getId().equals(id));
    }
}
