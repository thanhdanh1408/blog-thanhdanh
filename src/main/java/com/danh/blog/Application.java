package com.danh.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Personal Blog application.
 *
 * <p>Uses Spring Boot auto-configuration to set up:
 * <ul>
 *   <li>Embedded Tomcat web server</li>
 *   <li>Spring MVC for request handling</li>
 *   <li>Thymeleaf for server-side template rendering</li>
 * </ul>
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("  Personal Blog");
        System.out.println("  Version 1.0.0");
        System.out.println("  Author : Phan Thanh Danh");
        System.out.println("=================================");

        SpringApplication.run(Application.class, args);
    }

}
