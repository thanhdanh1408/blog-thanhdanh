package com.danh.blog.repository;

import com.danh.blog.model.Blog;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In-memory repository for blog posts.
 *
 * <p>Stores blog data in a List for Version 1.
 * Will be replaced by Spring Data JPA repository in Version 2.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@Repository
public class BlogRepository {

    private final List<Blog> blogs = new ArrayList<>();

    /**
     * Initializes sample blog data after bean construction.
     */
    @PostConstruct
    public void init() {
        blogs.add(new Blog(
                1L,
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

        blogs.add(new Blog(
                2L,
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
                        + "Spring Boot lại mạnh mẽ và tiện lợi đến vậy. Chúng xử lý rất nhiều thứ phức tạp mà "
                        + "chúng ta thường không nhận ra.</p>",
                "Phan Thanh Danh",
                LocalDate.of(2025, 6, 20),
                List.of("Java", "HTTP", "Networking", "Server")
        ));

        blogs.add(new Blog(
                3L,
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
                        + "</ul>"
                        + "<h3>Bắt đầu như thế nào?</h3>"
                        + "<p>Bước đầu tiên là tạo project với Spring Initializr hoặc sử dụng Gradle/Maven. "
                        + "Thêm các starter dependencies cần thiết và bạn đã có một ứng dụng web chạy được!</p>"
                        + "<p>Trong blog tiếp theo, tôi sẽ chia sẻ chi tiết hơn về kiến trúc MVC trong Spring Boot.</p>",
                "Phan Thanh Danh",
                LocalDate.of(2025, 9, 10),
                List.of("Spring Boot", "Java", "Web Development")
        ));

        blogs.add(new Blog(
                4L,
                "Kiến trúc MVC trong thực tế",
                "Giải thích mô hình MVC và cách áp dụng trong dự án Spring Boot thực tế.",
                "<p>MVC (Model - View - Controller) là một trong những design patterns quan trọng nhất "
                        + "trong phát triển web. Hiểu và áp dụng đúng MVC giúp code dễ bảo trì và mở rộng.</p>"
                        + "<h3>Ba thành phần của MVC</h3>"
                        + "<ul>"
                        + "<li><strong>Model</strong> — Chứa dữ liệu và business logic</li>"
                        + "<li><strong>View</strong> — Hiển thị dữ liệu cho người dùng (HTML, Thymeleaf)</li>"
                        + "<li><strong>Controller</strong> — Xử lý request, điều phối giữa Model và View</li>"
                        + "</ul>"
                        + "<h3>Layered Architecture</h3>"
                        + "<p>Trong thực tế, MVC thường được kết hợp với Layered Architecture:</p>"
                        + "<ol>"
                        + "<li><strong>Controller Layer</strong> — Nhận request, gọi service</li>"
                        + "<li><strong>Service Layer</strong> — Xử lý business logic</li>"
                        + "<li><strong>Repository Layer</strong> — Truy cập dữ liệu</li>"
                        + "</ol>"
                        + "<p>Dự án Personal Blog này chính là một ví dụ thực tế về cách áp dụng MVC + Layered Architecture.</p>",
                "Phan Thanh Danh",
                LocalDate.of(2026, 1, 5),
                List.of("MVC", "Architecture", "Spring Boot", "Design Pattern")
        ));
    }

    /**
     * Returns all blog posts.
     *
     * @return an unmodifiable list of all blogs
     */
    public List<Blog> findAll() {
        return List.copyOf(blogs);
    }

    /**
     * Finds a blog post by its ID.
     *
     * @param id the blog post ID
     * @return an Optional containing the blog if found
     */
    public Optional<Blog> findById(Long id) {
        return blogs.stream()
                .filter(blog -> blog.getId().equals(id))
                .findFirst();
    }

}
