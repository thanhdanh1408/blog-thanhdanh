package com.danh.blog.controller.admin;

import com.danh.blog.dto.BlogDTO;
import com.danh.blog.model.Blog;
import com.danh.blog.service.BlogService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Admin controller for blog post CRUD operations.
 *
 * <p>Provides endpoints for listing, creating, editing,
 * and deleting blog posts through the admin dashboard.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Controller
@RequestMapping("/admin/blogs")
public class AdminBlogController {

    private final BlogService blogService;

    public AdminBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * Displays the list of all blog posts for admin management.
     */
    @GetMapping
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        model.addAttribute("currentPage", "blogs");
        return "admin/blog-list";
    }

    /**
     * Displays the form for creating a new blog post.
     */
    @GetMapping("/new")
    public String newBlogForm(Model model) {
        model.addAttribute("blogDTO", new BlogDTO());
        model.addAttribute("currentPage", "blogs");
        model.addAttribute("isEdit", false);
        return "admin/blog-form";
    }

    /**
     * Processes the creation of a new blog post.
     */
    @PostMapping
    public String createBlog(@Valid @ModelAttribute("blogDTO") BlogDTO blogDTO,
                             BindingResult result,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("currentPage", "blogs");
            model.addAttribute("isEdit", false);
            return "admin/blog-form";
        }

        Blog blog = convertToEntity(blogDTO);
        blog.setPublishedDate(LocalDate.now());
        blogService.saveBlog(blog);

        redirectAttributes.addFlashAttribute("successMessage", "Tạo bài viết thành công!");
        return "redirect:/admin/blogs";
    }

    /**
     * Displays the form for editing an existing blog post.
     */
    @GetMapping("/edit/{id}")
    public String editBlogForm(@PathVariable Long id, Model model,
                               RedirectAttributes redirectAttributes) {
        return blogService.getBlogById(id)
                .map(blog -> {
                    model.addAttribute("blogDTO", convertToDTO(blog));
                    model.addAttribute("currentPage", "blogs");
                    model.addAttribute("isEdit", true);
                    return "admin/blog-form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Bài viết không tồn tại!");
                    return "redirect:/admin/blogs";
                });
    }

    /**
     * Processes the update of an existing blog post.
     */
    @PostMapping("/edit/{id}")
    public String updateBlog(@PathVariable Long id,
                             @Valid @ModelAttribute("blogDTO") BlogDTO blogDTO,
                             BindingResult result,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("currentPage", "blogs");
            model.addAttribute("isEdit", true);
            return "admin/blog-form";
        }

        return blogService.getBlogById(id)
                .map(existingBlog -> {
                    existingBlog.setTitle(blogDTO.getTitle());
                    existingBlog.setDescription(blogDTO.getDescription());
                    existingBlog.setContent(blogDTO.getContent());
                    existingBlog.setAuthor(blogDTO.getAuthor());
                    existingBlog.setTags(parseTags(blogDTO.getTags()));
                    blogService.saveBlog(existingBlog);

                    redirectAttributes.addFlashAttribute("successMessage", "Cập nhật bài viết thành công!");
                    return "redirect:/admin/blogs";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Bài viết không tồn tại!");
                    return "redirect:/admin/blogs";
                });
    }

    /**
     * Deletes a blog post by ID.
     */
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (blogService.getBlogById(id).isPresent()) {
            blogService.deleteBlog(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa bài viết thành công!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Bài viết không tồn tại!");
        }
        return "redirect:/admin/blogs";
    }

    // ==================== Helper Methods ====================

    /**
     * Converts a BlogDTO to a Blog entity.
     */
    private Blog convertToEntity(BlogDTO dto) {
        Blog blog = new Blog();
        blog.setId(dto.getId());
        blog.setTitle(dto.getTitle());
        blog.setDescription(dto.getDescription());
        blog.setContent(dto.getContent());
        blog.setAuthor(dto.getAuthor());
        blog.setTags(parseTags(dto.getTags()));
        return blog;
    }

    /**
     * Converts a Blog entity to a BlogDTO.
     */
    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setDescription(blog.getDescription());
        dto.setContent(blog.getContent());
        dto.setAuthor(blog.getAuthor());
        dto.setTags(blog.getTags() != null ? String.join(", ", blog.getTags()) : "");
        return dto;
    }

    /**
     * Parses a comma-separated tags string into a List.
     */
    private List<String> parseTags(String tagsString) {
        if (tagsString == null || tagsString.isBlank()) {
            return List.of();
        }
        return Arrays.stream(tagsString.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

}
