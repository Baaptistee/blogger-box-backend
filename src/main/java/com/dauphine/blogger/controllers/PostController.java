package com.dauphine.blogger.controllers;

import com.dauphine.blogger.DTO.PostRequest;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Post>> retrieveAllPosts() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> retrievePostById(@PathVariable UUID id) {
        Post post = this.service.getById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Post>> retrieveAllPostsByCategoryId(@PathVariable UUID categoryId) {
        return ResponseEntity.ok(this.service.getAllByCategoryId(categoryId));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) {
        Post created = this.service.create(postRequest.getCategory(), postRequest.getName(), postRequest.getContent());
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable UUID id, @RequestBody PostRequest postRequest) {
        Post updated = this.service.update(id, postRequest.getCategory(), postRequest.getName(), postRequest.getContent());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable UUID id) {
        boolean deleted = this.service.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }
}
