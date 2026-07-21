package com.danh.blog.controller.admin;

import com.danh.blog.dto.ProjectDTO;
import com.danh.blog.model.Project;
import com.danh.blog.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Admin controller for project CRUD operations.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Controller
@RequestMapping("/admin/projects")
public class AdminProjectController {

    private final ProjectService projectService;

    public AdminProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Displays the list of all projects for admin management.
     */
    @GetMapping
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        model.addAttribute("currentPage", "projects");
        return "admin/project-list";
    }

    /**
     * Displays the form for creating a new project.
     */
    @GetMapping("/new")
    public String newProjectForm(Model model) {
        model.addAttribute("projectDTO", new ProjectDTO());
        model.addAttribute("currentPage", "projects");
        model.addAttribute("isEdit", false);
        return "admin/project-form";
    }

    /**
     * Processes the creation of a new project.
     */
    @PostMapping
    public String createProject(@Valid @ModelAttribute("projectDTO") ProjectDTO projectDTO,
                                BindingResult result,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("currentPage", "projects");
            model.addAttribute("isEdit", false);
            return "admin/project-form";
        }

        Project project = convertToEntity(projectDTO);
        projectService.saveProject(project);

        redirectAttributes.addFlashAttribute("successMessage", "Tạo project thành công!");
        return "redirect:/admin/projects";
    }

    /**
     * Displays the form for editing an existing project.
     */
    @GetMapping("/edit/{id}")
    public String editProjectForm(@PathVariable Long id, Model model,
                                  RedirectAttributes redirectAttributes) {
        return projectService.getProjectById(id)
                .map(project -> {
                    model.addAttribute("projectDTO", convertToDTO(project));
                    model.addAttribute("currentPage", "projects");
                    model.addAttribute("isEdit", true);
                    return "admin/project-form";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Project không tồn tại!");
                    return "redirect:/admin/projects";
                });
    }

    /**
     * Processes the update of an existing project.
     */
    @PostMapping("/edit/{id}")
    public String updateProject(@PathVariable Long id,
                                @Valid @ModelAttribute("projectDTO") ProjectDTO projectDTO,
                                BindingResult result,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        if (result.hasErrors()) {
            model.addAttribute("currentPage", "projects");
            model.addAttribute("isEdit", true);
            return "admin/project-form";
        }

        return projectService.getProjectById(id)
                .map(existingProject -> {
                    existingProject.setName(projectDTO.getName());
                    existingProject.setDescription(projectDTO.getDescription());
                    existingProject.setImageUrl(projectDTO.getImageUrl());
                    existingProject.setTechnologies(parseTechnologies(projectDTO.getTechnologies()));
                    existingProject.setGithubUrl(projectDTO.getGithubUrl());
                    existingProject.setDemoUrl(projectDTO.getDemoUrl());
                    projectService.saveProject(existingProject);

                    redirectAttributes.addFlashAttribute("successMessage", "Cập nhật project thành công!");
                    return "redirect:/admin/projects";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Project không tồn tại!");
                    return "redirect:/admin/projects";
                });
    }

    /**
     * Deletes a project by ID.
     */
    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (projectService.getProjectById(id).isPresent()) {
            projectService.deleteProject(id);
            redirectAttributes.addFlashAttribute("successMessage", "Xóa project thành công!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Project không tồn tại!");
        }
        return "redirect:/admin/projects";
    }

    // ==================== Helper Methods ====================

    private Project convertToEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setImageUrl(dto.getImageUrl());
        project.setTechnologies(parseTechnologies(dto.getTechnologies()));
        project.setGithubUrl(dto.getGithubUrl());
        project.setDemoUrl(dto.getDemoUrl());
        return project;
    }

    private ProjectDTO convertToDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setImageUrl(project.getImageUrl());
        dto.setTechnologies(project.getTechnologies() != null
                ? String.join(", ", project.getTechnologies()) : "");
        dto.setGithubUrl(project.getGithubUrl());
        dto.setDemoUrl(project.getDemoUrl());
        return dto;
    }

    private List<String> parseTechnologies(String techString) {
        if (techString == null || techString.isBlank()) {
            return List.of();
        }
        return Arrays.stream(techString.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

}
