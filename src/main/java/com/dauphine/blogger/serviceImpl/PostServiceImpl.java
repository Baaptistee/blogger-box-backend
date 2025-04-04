package com.dauphine.blogger.serviceImpl;

import com.dauphine.blogger.model.Category;
import com.dauphine.blogger.model.Post;
import com.dauphine.blogger.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final List<Post> posts;

    public PostServiceImpl() {
        posts = new ArrayList<>();
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryID) {
        List<Post> postscategory = new ArrayList<>();
        for (Post post : posts) {
            if (post.getCategory().getId() == categoryID) {
                postscategory.add(post);
            }
        }
        return postscategory;
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post getById(UUID id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }

        return null;
    }

    @Override
    public Post create(Category category, String title, String content, UUID categoryId) {
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setCategory(category);
        newPost.setId(UUID.randomUUID());
        posts.add(newPost);
        return newPost;
    }

    @Override
    public Post update(UUID id, Category category, String title, String content) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                post.setTitle(title);
                post.setContent(content);
                post.setCategory(category);
                return post;
            }
        }

        return null;
    }

    @Override
    public boolean deleteById(UUID id) {
        return posts.removeIf(post -> post.getId().equals(id));
    }
}
