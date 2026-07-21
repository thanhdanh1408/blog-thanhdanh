package com.danh.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Data Transfer Object for project forms.
 *
 * <p>Used for create/edit project forms with validation.
 * Technologies are input as a comma-separated string.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
public class ProjectDTO {

    private Long id;

    @NotBlank(message = "Tên project không được để trống")
    @Size(max = 200, message = "Tên project không quá 200 ký tự")
    private String name;

    @NotBlank(message = "Mô tả không được để trống")
    private String description;

    @Size(max = 500, message = "URL hình ảnh không quá 500 ký tự")
    private String imageUrl;

    /**
     * Technologies as a comma-separated string.
     * Example: "Java, Spring Boot, MySQL"
     */
    private String technologies;

    @Size(max = 500, message = "GitHub URL không quá 500 ký tự")
    private String githubUrl;

    @Size(max = 500, message = "Demo URL không quá 500 ký tự")
    private String demoUrl;

    // ==================== Getters & Setters ====================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

}
