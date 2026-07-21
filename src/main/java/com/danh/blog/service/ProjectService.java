package com.danh.blog.service;

import com.danh.blog.model.Project;
import com.danh.blog.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for project operations.
 *
 * <p>Provides CRUD operations and business logic
 * for project management.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    /**
     * Constructs a ProjectService with the given repository.
     *
     * @param projectRepository the project data repository
     */
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Retrieves all projects.
     *
     * @return a list of all projects
     */
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    /**
     * Retrieves a project by its ID.
     *
     * @param id the project ID
     * @return an Optional containing the project if found
     */
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    /**
     * Saves a new project or updates an existing one.
     *
     * @param project the project to save
     * @return the saved project with generated ID
     */
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    /**
     * Deletes a project by its ID.
     *
     * @param id the project ID to delete
     */
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    /**
     * Returns the total count of projects.
     *
     * @return the number of projects
     */
    public long count() {
        return projectRepository.count();
    }

}
