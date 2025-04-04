package com.dauphine.blogger.controllers;
import com.dauphine.blogger.model.Category;
import com.dauphine.blogger.model.Post;
import com.dauphine.blogger.service.PostService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(
        name = "Post Controller API",
        description = "My post endpoints"
)
@RequestMapping("/v1/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> retreiveAllPosts() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Post retreivePostById(@PathVariable UUID id) {
        return this.service.getById(id);
    }

    @GetMapping("/category/{id}")
    public List<Post> retreiveAllPostsByCategoryId(@PathVariable UUID id) {
        return this.service.getAllByCategoryId(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Category category, String title, String content, UUID categoryId) {
        return this.service.create(category, title, content, categoryId);
    }

    @PutMapping("/{id}")
    public Post updatePost(@RequestBody String name, Category category,  String description, UUID postId) {
        return this.service.update(postId, category, name, description);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategoryById(@PathVariable UUID id) {
        return this.service.deleteById(id);
    }
}
