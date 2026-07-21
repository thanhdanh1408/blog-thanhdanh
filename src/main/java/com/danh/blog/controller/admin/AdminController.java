package com.danh.blog.controller.admin;

import com.danh.blog.service.BlogService;
import com.danh.blog.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the admin dashboard and login pages.
 *
 * <p>Handles admin authentication entry point and
 * the main dashboard with summary statistics.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final BlogService blogService;
    private final ProjectService projectService;

    public AdminController(BlogService blogService, ProjectService projectService) {
        this.blogService = blogService;
        this.projectService = projectService;
    }

    /**
     * Displays the admin login page.
     */
    @GetMapping("/login")
    public String loginPage() {
        return "admin/login";
    }

    /**
     * Displays the admin dashboard with summary statistics.
     */
    @GetMapping({"", "/"})
    public String dashboard(Model model) {
        model.addAttribute("blogCount", blogService.count());
        model.addAttribute("projectCount", projectService.count());
        model.addAttribute("currentPage", "dashboard");
        return "admin/dashboard";
    }

}
