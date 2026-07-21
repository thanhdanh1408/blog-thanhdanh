package com.danh.blog.service;

import com.danh.blog.model.AdminUser;
import com.danh.blog.repository.AdminUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Custom UserDetailsService for Spring Security authentication.
 *
 * <p>Loads admin user information from the database
 * and converts it to Spring Security's UserDetails format.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminUserRepository adminUserRepository;

    public CustomUserDetailsService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    /**
     * Loads a user by username for authentication.
     *
     * @param username the username to look up
     * @return the UserDetails for Spring Security
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser adminUser = adminUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Không tìm thấy tài khoản: " + username));

        return new User(
                adminUser.getUsername(),
                adminUser.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + adminUser.getRole()))
        );
    }

}
