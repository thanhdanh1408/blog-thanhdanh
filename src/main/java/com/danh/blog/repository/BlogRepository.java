package com.danh.blog.repository;

import com.danh.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JPA repository for blog post data access.
 *
 * <p>Extends JpaRepository to get full CRUD operations
 * automatically. Custom query methods are defined by
 * Spring Data's method naming convention.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    /**
     * Finds all blog posts ordered by published date descending (newest first).
     *
     * @return list of blogs sorted by date
     */
    List<Blog> findAllByOrderByPublishedDateDesc();

}
