package com.danh.blog.repository;

import com.danh.blog.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository for project data access.
 *
 * <p>Extends JpaRepository to get full CRUD operations
 * automatically via Spring Data JPA.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
