package com.danh.blog.controller;

import com.danh.blog.model.Project;
import com.danh.blog.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controller for the Projects page.
 *
 * <p>Displays a showcase of personal projects with descriptions,
 * technologies used, and links to source code and demos.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@Controller
public class ProjectController {

    private final ProjectService projectService;

    /**
     * Constructs a ProjectController with the given ProjectService.
     *
     * @param projectService the service for project operations
     */
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Displays the projects showcase page.
     *
     * @param model the Spring MVC model
     * @return the projects template name
     */
    @GetMapping("/projects")
    public String projects(Model model) {
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }

}
