package com.danh.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * Controller for the About page.
 *
 * <p>Displays personal information including bio, education,
 * skills, tech stack, and learning timeline.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@Controller
public class AboutController {

    /**
     * Displays the about page with personal details.
     *
     * @param model the Spring MVC model to pass data to the view
     * @return the name of the Thymeleaf template to render
     */
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "Phan Thanh Danh");

        model.addAttribute("bio", "Tôi là một sinh viên ngành Công nghệ Thông tin, "
                + "đam mê lập trình Java và phát triển backend. Tôi tin rằng việc xây dựng "
                + "nền tảng vững chắc từ những kiến thức cốt lõi sẽ giúp tôi trở thành "
                + "một lập trình viên giỏi hơn mỗi ngày. Hiện tại, tôi đang tập trung "
                + "vào Spring Boot, kiến trúc phần mềm và các best practices trong phát triển phần mềm.");

        model.addAttribute("education", getEducation());
        model.addAttribute("skills", getSkills());
        model.addAttribute("techStack", getTechStack());
        model.addAttribute("timeline", getTimeline());

        return "about";
    }

    /**
     * Returns education information.
     */
    private List<Map<String, String>> getEducation() {
        return List.of(
                Map.of(
                        "school", "Trường Đại học ...",
                        "major", "Công nghệ Thông tin",
                        "period", "2022 - 2026",
                        "description", "Chuyên ngành Kỹ thuật Phần mềm"
                )
        );
    }

    /**
     * Returns skill categories with individual skills.
     */
    private List<Map<String, Object>> getSkills() {
        return List.of(
                Map.of("category", "Backend",
                        "items", List.of("Java", "Spring Boot", "Spring MVC", "REST API")),
                Map.of("category", "Frontend",
                        "items", List.of("HTML5", "CSS3", "Bootstrap 5", "Thymeleaf")),
                Map.of("category", "Database",
                        "items", List.of("MySQL", "SQL")),
                Map.of("category", "Tools",
                        "items", List.of("Git", "GitHub", "VS Code", "Gradle"))
        );
    }

    /**
     * Returns technology stack with icon class names.
     */
    private List<Map<String, String>> getTechStack() {
        return List.of(
                Map.of("name", "Java", "icon", "bi-filetype-java"),
                Map.of("name", "Spring Boot", "icon", "bi-box"),
                Map.of("name", "Thymeleaf", "icon", "bi-file-earmark-code"),
                Map.of("name", "HTML5", "icon", "bi-filetype-html"),
                Map.of("name", "CSS3", "icon", "bi-filetype-css"),
                Map.of("name", "Bootstrap", "icon", "bi-bootstrap"),
                Map.of("name", "MySQL", "icon", "bi-database"),
                Map.of("name", "Git", "icon", "bi-git"),
                Map.of("name", "GitHub", "icon", "bi-github"),
                Map.of("name", "Gradle", "icon", "bi-gear"),
                Map.of("name", "Docker", "icon", "bi-box-seam"),
                Map.of("name", "VS Code", "icon", "bi-code-slash")
        );
    }

    /**
     * Returns learning timeline entries in chronological order.
     */
    private List<Map<String, String>> getTimeline() {
        return List.of(
                Map.of("year", "2022",
                        "title", "Bắt đầu học lập trình",
                        "description", "Làm quen với ngôn ngữ C/C++ và các khái niệm cơ bản về lập trình."),
                Map.of("year", "2023",
                        "title", "Học Java Core",
                        "description", "Nắm vững OOP, Collections, Exception Handling, I/O và các design patterns cơ bản."),
                Map.of("year", "2024",
                        "title", "Học Web Development",
                        "description", "HTML, CSS, JavaScript, Bootstrap. Xây dựng các project frontend đầu tiên."),
                Map.of("year", "2025",
                        "title", "Spring Framework & Backend",
                        "description", "Bắt đầu học Spring Boot, Spring MVC, Thymeleaf, REST API và kiến trúc MVC."),
                Map.of("year", "2026",
                        "title", "Portfolio & Dự án thực tế",
                        "description", "Xây dựng Personal Blog, áp dụng các kiến thức đã học vào dự án thực tế.")
        );
    }

}
