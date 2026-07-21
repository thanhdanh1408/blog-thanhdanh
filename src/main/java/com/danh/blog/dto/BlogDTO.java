package com.danh.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object for blog post forms.
 *
 * <p>Used for create/edit blog forms with validation.
 * Tags are input as a comma-separated string
 * and converted to a List in the controller.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
public class BlogDTO {

    private Long id;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 200, message = "Tiêu đề không quá 200 ký tự")
    private String title;

    @NotBlank(message = "Mô tả không được để trống")
    @Size(max = 500, message = "Mô tả không quá 500 ký tự")
    private String description;

    @NotBlank(message = "Nội dung không được để trống")
    private String content;

    @Size(max = 100, message = "Tên tác giả không quá 100 ký tự")
    private String author;

    /**
     * Tags as a comma-separated string for form input.
     * Example: "Java, Spring Boot, Web"
     */
    private String tags;

    // ==================== Getters & Setters ====================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

}
