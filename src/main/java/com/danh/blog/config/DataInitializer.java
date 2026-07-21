package com.danh.blog.config;

import com.danh.blog.model.AdminUser;
import com.danh.blog.model.Blog;
import com.danh.blog.model.Project;
import com.danh.blog.repository.AdminUserRepository;
import com.danh.blog.repository.BlogRepository;
import com.danh.blog.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Initializes sample data on first startup.
 *
 * <p>Checks if the database is empty and inserts sample
 * blog posts, projects, and a default admin user.
 * Runs only when there is no existing data.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final BlogRepository blogRepository;
    private final ProjectRepository projectRepository;
    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(BlogRepository blogRepository,
                           ProjectRepository projectRepository,
                           AdminUserRepository adminUserRepository,
                           PasswordEncoder passwordEncoder) {
        this.blogRepository = blogRepository;
        this.projectRepository = projectRepository;
        this.adminUserRepository = adminUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        initAdminUser();
        initBlogs();
        initProjects();
    }

    /**
     * Creates default admin user if none exists.
     * Default credentials: admin / admin123
     */
    private void initAdminUser() {
        if (adminUserRepository.count() == 0) {
            AdminUser admin = new AdminUser(
                    "admin",
                    passwordEncoder.encode("admin123"),
                    "ADMIN"
            );
            adminUserRepository.save(admin);
            log.info("✅ Default admin user created (username: admin, password: admin123)");
        }
    }

    /**
     * Inserts sample blog posts if none exist.
     */
    private void initBlogs() {
        if (blogRepository.count() > 0) {
            return;
        }

        blogRepository.save(new Blog(
                null,
                "Hành trình học Java của tôi",
                "Chia sẻ kinh nghiệm từ những ngày đầu tiên làm quen với Java cho đến khi xây dựng được ứng dụng thực tế.",
                "<p>Java là ngôn ngữ lập trình đầu tiên tôi thực sự nghiêm túc học. "
                        + "Ban đầu, mọi thứ đều rất khó khăn — từ việc hiểu biến, vòng lặp cho đến OOP.</p>"
                        + "<p>Tuy nhiên, qua thời gian kiên trì thực hành mỗi ngày, tôi dần hiểu được vẻ đẹp "
                        + "của Java: tính nhất quán, hệ sinh thái phong phú, và khả năng mở rộng tuyệt vời.</p>"
                        + "<h3>Những bài học quan trọng</h3>"
                        + "<ul>"
                        + "<li><strong>OOP không chỉ là lý thuyết</strong> — hãy áp dụng vào project thực tế</li>"
                        + "<li><strong>Collections Framework</strong> — là nền tảng cho mọi ứng dụng Java</li>"
                        + "<li><strong>Exception Handling</strong> — viết code an toàn và dễ debug</li>"
                        + "<li><strong>Clean Code</strong> — đặt tên biến rõ ràng, method ngắn gọn</li>"
                        + "</ul>"
                        + "<p>Lời khuyên của tôi: Hãy code mỗi ngày, dù chỉ 30 phút. Sự nhất quán sẽ mang lại kết quả.</p>",
                "Phan Thanh Danh",
                LocalDate.of(2025, 3, 15),
                List.of("Java", "Learning", "Programming")
        ));

        blogRepository.save(new Blog(
                null,
                "Xây dựng HTTP Server từ đầu bằng Java",
                "Tìm hiểu cách HTTP hoạt động bằng cách tự xây dựng một web server đơn giản với Java Socket.",
                "<p>Một trong những project thú vị nhất tôi từng làm là tự xây dựng một HTTP Server "
                        + "từ đầu chỉ bằng Java Socket. Điều này giúp tôi hiểu sâu hơn về cách web hoạt động.</p>"
                        + "<h3>HTTP Server hoạt động như thế nào?</h3>"
                        + "<p>Một HTTP Server cơ bản cần thực hiện các bước:</p>"
                        + "<ol>"
                        + "<li>Mở một ServerSocket lắng nghe trên một port</li>"
                        + "<li>Chấp nhận kết nối từ client (browser)</li>"
                        + "<li>Đọc và parse HTTP Request</li>"
                        + "<li>Xử lý request và tạo HTTP Response</li>"
                        + "<li>Gửi response về cho client</li>"
                        + "</ol>"
                        + "<h3>Bài học rút ra</h3>"
                        + "<p>Sau khi tự build HTTP Server, tôi hiểu rõ hơn tại sao các framework như "
                        + "Spring Boot lại mạnh mẽ và tiện lợi đến vậy.</p>",
                "Phan Thanh Danh",
                LocalDate.of(2025, 6, 20),
                List.of("Java", "HTTP", "Networking", "Server")
        ));

        blogRepository.save(new Blog(
                null,
                "Spring Boot cho người mới bắt đầu",
                "Hướng dẫn cơ bản về Spring Boot: từ khởi tạo project đến chạy ứng dụng web đầu tiên.",
                "<p>Spring Boot là framework Java phổ biến nhất cho phát triển ứng dụng web. "
                        + "Nó giúp đơn giản hóa việc cấu hình Spring Framework truyền thống.</p>"
                        + "<h3>Tại sao chọn Spring Boot?</h3>"
                        + "<ul>"
                        + "<li><strong>Auto-configuration</strong> — tự động cấu hình dựa trên dependencies</li>"
                        + "<li><strong>Embedded Server</strong> — không cần cài đặt Tomcat riêng</li>"
                        + "<li><strong>Starter Dependencies</strong> — quản lý phiên bản tự động</li>"
                        + "<li><strong>Production-ready</strong> — actuator, logging, metrics sẵn có</li>"
                        + "</ul>",
                "Phan Thanh Danh",
                LocalDate.of(2025, 9, 10),
                List.of("Spring Boot", "Java", "Web Development")
        ));

        blogRepository.save(new Blog(
                null,
                "Kiến trúc MVC trong thực tế",
                "Giải thích mô hình MVC và cách áp dụng trong dự án Spring Boot thực tế.",
                "<p>MVC (Model - View - Controller) là một trong những design patterns quan trọng nhất "
                        + "trong phát triển web.</p>"
                        + "<h3>Ba thành phần của MVC</h3>"
                        + "<ul>"
                        + "<li><strong>Model</strong> — Chứa dữ liệu và business logic</li>"
                        + "<li><strong>View</strong> — Hiển thị dữ liệu cho người dùng</li>"
                        + "<li><strong>Controller</strong> — Xử lý request, điều phối giữa Model và View</li>"
                        + "</ul>",
                "Phan Thanh Danh",
                LocalDate.of(2026, 1, 5),
                List.of("MVC", "Architecture", "Spring Boot", "Design Pattern")
        ));

        log.info("✅ Sample blog posts initialized (4 posts)");
    }

    /**
     * Inserts sample projects if none exist.
     */
    private void initProjects() {
        if (projectRepository.count() > 0) {
            return;
        }

        projectRepository.save(new Project(
                null,
                "Personal Blog",
                "Website blog cá nhân và portfolio được xây dựng bằng Java, Spring Boot 3 và Thymeleaf. "
                        + "Áp dụng kiến trúc MVC + Layered Architecture.",
                null,
                List.of("Java 21", "Spring Boot 3", "Thymeleaf", "Bootstrap 5", "H2 Database"),
                "https://github.com/thanhdanh/personal-blog",
                "#"
        ));

        projectRepository.save(new Project(
                null,
                "Java HTTP Server",
                "HTTP Server tự xây dựng từ đầu bằng Java Socket. Hỗ trợ GET/POST, "
                        + "static file serving và routing cơ bản.",
                null,
                List.of("Java", "Socket", "HTTP", "Multithreading"),
                "https://github.com/thanhdanh/java-http-server",
                null
        ));

        projectRepository.save(new Project(
                null,
                "Task Manager CLI",
                "Ứng dụng quản lý công việc qua dòng lệnh (CLI). Hỗ trợ CRUD tasks, "
                        + "filter theo trạng thái và export ra file.",
                null,
                List.of("Java", "JDBC", "SQLite", "CLI"),
                "https://github.com/thanhdanh/task-manager",
                null
        ));

        log.info("✅ Sample projects initialized (3 projects)");
    }

}
