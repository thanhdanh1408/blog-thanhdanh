package com.danh.blog.service;

import com.danh.blog.model.Blog;
import com.danh.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for blog post operations.
 *
 * <p>Acts as an intermediary between the controller and repository layers,
 * encapsulating business logic for blog management.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    /**
     * Constructs a BlogService with the given repository.
     *
     * @param blogRepository the blog data repository
     */
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * Retrieves all blog posts.
     *
     * @return a list of all blog posts
     */
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    /**
     * Retrieves a blog post by its ID.
     *
     * @param id the blog post ID
     * @return an Optional containing the blog if found
     */
    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

}
