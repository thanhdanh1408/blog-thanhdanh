package com.danh.blog.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Domain model representing a blog post.
 *
 * <p>Contains all the information needed to display a blog post
 * in both list view (title, description, date) and detail view
 * (full content).
 *
 * <p>In Version 1, instances are created in-memory by the repository.
 * In Version 2, this will be mapped to a database table via JPA.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
public class Blog {

    private Long id;
    private String title;
    private String description;
    private String content;
    private String author;
    private LocalDate publishedDate;
    private List<String> tags;

    /**
     * Default constructor.
     */
    public Blog() {
    }

    /**
     * Constructs a Blog with all fields.
     */
    public Blog(Long id, String title, String description, String content,
                String author, LocalDate publishedDate, List<String> tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.publishedDate = publishedDate;
        this.tags = tags;
    }

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

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }

}
