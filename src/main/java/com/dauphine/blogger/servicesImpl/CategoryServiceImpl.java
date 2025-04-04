package com.dauphine.blogger.servicesImpl;

import com.dauphine.blogger.exceptions.CategoryIdNotFound;
import com.dauphine.blogger.exceptions.CategoryNameAlreadyExists;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public List<Category> getByName(String name) {
        List<Category> categories = new ArrayList<>();
        return categoryRepository.findAllByName(name);
    }

    @Override
    public Category getById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryIdNotFound(id));
    }

    @Override
    public Category create(String name) throws CategoryNameAlreadyExists {
        Category newCategory = new Category();
        newCategory.setName(name);
        newCategory.setId(UUID.randomUUID());

        if (categoryRepository.doesNameExist(name)){
            throw new CategoryNameAlreadyExists(name);
        } else {
            return categoryRepository.save(newCategory);
        }
    }

    @Override
    public Category update(UUID id, String name) {
        Category category = getById(id);
        if (category == null) {return null;}
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteById(UUID id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
