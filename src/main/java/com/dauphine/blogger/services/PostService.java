package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllByCategoryId(UUID categoryID);

    List<Post> getAll();

    Post getById(UUID id);

    Post create(Category category, String title, String content);

    Post update(UUID id, Category category, String title, String content);

    boolean deleteById(UUID id);
}
