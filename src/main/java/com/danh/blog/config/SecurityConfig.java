package com.danh.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security configuration.
 *
 * <p>Configures URL-based authorization:
 * <ul>
 *   <li>Public pages (/, /about, /blog, etc.) — accessible by everyone</li>
 *   <li>Admin pages (/admin/**) — require ADMIN role authentication</li>
 *   <li>Static resources (CSS, JS, images) — always accessible</li>
 * </ul>
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain with URL patterns,
     * custom login page, and logout behavior.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Static resources — always accessible
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.svg").permitAll()
                        // H2 Console (development only)
                        .requestMatchers("/h2-console/**").permitAll()
                        // Admin login page — accessible without login
                        .requestMatchers("/admin/login").permitAll()
                        // All admin pages — require ADMIN role
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        // Everything else (public pages) — accessible by everyone
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/admin/login")
                        .loginProcessingUrl("/admin/login")
                        .defaultSuccessUrl("/admin/", true)
                        .failureUrl("/admin/login?error=true")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/admin/logout")
                        .logoutSuccessUrl("/admin/login?logout=true")
                        .permitAll()
                )
                // Allow H2 Console frames (development only)
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                );

        return http.build();
    }

    /**
     * Password encoder using BCrypt hashing algorithm.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
