package com.danh.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * Controller for the Contact page.
 *
 * <p>Displays contact information including email,
 * social media links, and a CV download option.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@Controller
public class ContactController {

    /**
     * Displays the contact page with social media links and contact info.
     *
     * @param model the Spring MVC model
     * @return the contact template name
     */
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("email", "thanhdanh@example.com");
        model.addAttribute("socialLinks", getSocialLinks());
        model.addAttribute("cvUrl", "#");
        return "contact";
    }

    /**
     * Returns a list of social media links with display info.
     */
    private List<Map<String, String>> getSocialLinks() {
        return List.of(
                Map.of("name", "GitHub",
                        "url", "https://github.com/thanhdanh",
                        "icon", "bi-github",
                        "color", "#333"),
                Map.of("name", "LinkedIn",
                        "url", "https://linkedin.com/in/thanhdanh",
                        "icon", "bi-linkedin",
                        "color", "#0077b5"),
                Map.of("name", "Facebook",
                        "url", "https://facebook.com/thanhdanh",
                        "icon", "bi-facebook",
                        "color", "#1877f2"),
                Map.of("name", "Instagram",
                        "url", "https://instagram.com/thanhdanh",
                        "icon", "bi-instagram",
                        "color", "#e4405f"),
                Map.of("name", "TikTok",
                        "url", "https://tiktok.com/@thanhdanh",
                        "icon", "bi-tiktok",
                        "color", "#000000")
        );
    }

}
