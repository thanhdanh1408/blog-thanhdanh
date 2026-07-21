package com.danh.blog.repository;

import com.danh.blog.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA repository for admin user data access.
 *
 * <p>Used by Spring Security's UserDetailsService
 * to load user information during authentication.
 *
 * @author Phan Thanh Danh
 * @version 2.0.0
 */
@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    /**
     * Finds an admin user by username.
     *
     * @param username the username to search for
     * @return an Optional containing the user if found
     */
    Optional<AdminUser> findByUsername(String username);

}
