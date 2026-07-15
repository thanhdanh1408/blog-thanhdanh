package com.danh.blog.model;

import java.util.List;

/**
 * Domain model representing a personal project.
 *
 * <p>Contains project details for the portfolio showcase including
 * name, description, technologies used, and external links.
 *
 * <p>In Version 1, instances are created in-memory by the repository.
 * In Version 2, this will be mapped to a database table via JPA.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
public class Project {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private List<String> technologies;
    private String githubUrl;
    private String demoUrl;

    /**
     * Default constructor.
     */
    public Project() {
    }

    /**
     * Constructs a Project with all fields.
     */
    public Project(Long id, String name, String description, String imageUrl,
                   List<String> technologies, String githubUrl, String demoUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.technologies = technologies;
        this.githubUrl = githubUrl;
        this.demoUrl = demoUrl;
    }

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

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technologies=" + technologies +
                '}';
    }

}
