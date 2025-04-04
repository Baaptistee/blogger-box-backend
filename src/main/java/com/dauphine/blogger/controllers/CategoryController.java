package com.dauphine.blogger.controllers;
import com.dauphine.blogger.model.Category;
import com.dauphine.blogger.service.CategoryService;
import com.dauphine.blogger.serviceImpl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(
        name = "Category Controller API",
        description = "My category endpoints"
)
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> retreiveAllCategories() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Category retreiveCategoryById(@PathVariable UUID id) {
        return this.service.getById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody String name,  String description, UUID categoryId) {
        return this.service.create(name, description, categoryId);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody String name,  String description, UUID categoryId) {
        return this.service.update(categoryId, name, description);
    }

    @DeleteMapping("{id}")
    public boolean deleteCategoryById(@PathVariable UUID id) {
        return this.service.deleteById(id);
    }


}
