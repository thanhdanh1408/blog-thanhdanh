package com.danh.blog.repository;

import com.danh.blog.model.Project;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In-memory repository for projects.
 *
 * <p>Stores project data in a List for Version 1.
 * Will be replaced by Spring Data JPA repository in Version 2.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@Repository
public class ProjectRepository {

    private final List<Project> projects = new ArrayList<>();

    /**
     * Initializes sample project data after bean construction.
     */
    @PostConstruct
    public void init() {
        projects.add(new Project(
                1L,
                "Personal Blog",
                "Website blog cá nhân và portfolio được xây dựng bằng Spring Boot, Thymeleaf và Bootstrap 5. "
                        + "Áp dụng kiến trúc MVC và Layered Architecture. Responsive trên Desktop và Mobile.",
                "/images/project-blog.png",
                List.of("Java", "Spring Boot", "Thymeleaf", "Bootstrap 5", "Gradle"),
                "https://github.com/thanhdanh/personal-blog",
                "#"
        ));

        projects.add(new Project(
                2L,
                "HTTP Server",
                "Tự xây dựng HTTP Server từ đầu bằng Java Socket. Hỗ trợ GET request, phục vụ file tĩnh "
                        + "(HTML, CSS, JS), routing và template engine đơn giản.",
                "/images/project-http.png",
                List.of("Java", "Socket", "HTTP", "Networking"),
                "https://github.com/thanhdanh/http-server",
                null
        ));

        projects.add(new Project(
                3L,
                "Todo Application",
                "Ứng dụng quản lý công việc đơn giản với giao diện web. Hỗ trợ thêm, sửa, xóa và đánh dấu "
                        + "hoàn thành công việc. Sử dụng Servlet và JSP.",
                "/images/project-todo.png",
                List.of("Java", "Servlet", "JSP", "MySQL", "Bootstrap"),
                "https://github.com/thanhdanh/todo-app",
                null
        ));
    }

    /**
     * Returns all projects.
     *
     * @return an unmodifiable list of all projects
     */
    public List<Project> findAll() {
        return List.copyOf(projects);
    }

    /**
     * Finds a project by its ID.
     *
     * @param id the project ID
     * @return an Optional containing the project if found
     */
    public Optional<Project> findById(Long id) {
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst();
    }

}
