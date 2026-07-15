package com.danh.blog.controller;

import com.danh.blog.exception.NotFoundException;
import com.danh.blog.model.Blog;
import com.danh.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Controller for the Blog module.
 *
 * <p>Handles displaying the blog post list and individual post details.
 * Delegates data retrieval to {@link BlogService}.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@Controller
public class BlogController {

    private final BlogService blogService;

    /**
     * Constructs a BlogController with the given BlogService.
     *
     * @param blogService the service for blog post operations
     */
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * Displays the blog listing page with all posts.
     *
     * @param model the Spring MVC model
     * @return the blog list template name
     */
    @GetMapping("/blog")
    public String blogList(Model model) {
        List<Blog> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        return "blog";
    }

    /**
     * Displays a single blog post by its ID.
     *
     * @param id    the blog post ID from the URL path
     * @param model the Spring MVC model
     * @return the post detail template name
     * @throws NotFoundException if no blog post exists with the given ID
     */
    @GetMapping("/blog/{id}")
    public String blogDetail(@PathVariable Long id, Model model) {
        Blog blog = blogService.getBlogById(id)
                .orElseThrow(() -> new NotFoundException("Bài viết không tồn tại với ID: " + id));
        model.addAttribute("blog", blog);
        return "post";
    }

}
