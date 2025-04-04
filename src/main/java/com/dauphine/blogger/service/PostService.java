package com.dauphine.blogger.service;

import com.dauphine.blogger.model.Category;
import com.dauphine.blogger.model.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllByCategoryId(UUID categoryID);

    List<Post> getAll();

    Post getById(UUID id);

    Post create(Category category, String title, String content, UUID categoryId);

    Post update(UUID id, Category category, String title, String content);

    boolean deleteById(UUID id);
}
