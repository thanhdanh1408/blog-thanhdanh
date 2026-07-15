package com.danh.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC configuration class.
 *
 * <p>Provides a central place for customizing Spring MVC behavior.
 * Future enhancements may include:
 * <ul>
 *   <li>CORS configuration</li>
 *   <li>Interceptors for logging or authentication</li>
 *   <li>Custom argument resolvers</li>
 *   <li>View controller mappings</li>
 * </ul>
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Spring Boot auto-configures static resource handling
    // and Thymeleaf view resolution via application.properties.
    //
    // Add custom MVC configurations here as the project grows.

}
