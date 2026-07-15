package com.danh.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the Home page.
 *
 * <p>Handles the root URL and renders the landing page
 * with personal introduction and navigation elements.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@Controller
public class HomeController {

    /**
     * Displays the home/landing page.
     *
     * @param model the Spring MVC model to pass data to the view
     * @return the name of the Thymeleaf template to render
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Phan Thanh Danh");
        model.addAttribute("title", "Java Backend Developer");
        model.addAttribute("tagline", "Đam mê xây dựng hệ thống backend sạch, mạnh mẽ và có khả năng mở rộng.");
        model.addAttribute("intro", "Xin chào! Tôi là một lập trình viên Java đang trên hành trình chinh phục "
                + "công nghệ backend. Tôi yêu thích việc viết code sạch, học hỏi kiến trúc phần mềm "
                + "và xây dựng những ứng dụng thực tế có giá trị.");
        return "home";
    }

}
