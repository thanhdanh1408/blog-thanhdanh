package com.danh.blog.service;

import com.danh.blog.model.Blog;
import com.danh.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for blog post operations.
 *
 * <p>Provides CRUD operations and business logic
 * for blog management.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
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
     * Retrieves all blog posts ordered by date (newest first).
     *
     * @return a list of all blog posts
     */
    public List<Blog> getAllBlogs() {
        return blogRepository.findAllByOrderByPublishedDateDesc();
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

    /**
     * Saves a new blog post or updates an existing one.
     *
     * @param blog the blog to save
     * @return the saved blog with generated ID
     */
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    /**
     * Deletes a blog post by its ID.
     *
     * @param id the blog post ID to delete
     */
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    /**
     * Returns the total count of blog posts.
     *
     * @return the number of blog posts
     */
    public long count() {
        return blogRepository.count();
    }

}
