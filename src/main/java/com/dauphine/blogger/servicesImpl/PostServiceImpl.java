package com.dauphine.blogger.servicesImpl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repositories.PostRepository;
import com.dauphine.blogger.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository=postRepository;
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryID) {
        return postRepository.findAllByCategoryId(categoryID);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(UUID id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post create( Category category, String title, String content) {
        Post post = new Post(category, title, content);
        return postRepository.save(post);
    }

    @Override
    public Post update(UUID id, Category category, String title, String content) {
        Post post = getById(id);
        if (category != null) {return null;}
        post.setTitle(title);
        post.setContent(content);
        post.setCategory(category);
        return postRepository.save(post);
    }

    @Override
    public boolean deleteById(UUID id) {
        postRepository.deleteById(id);
        return true;
    }
}
