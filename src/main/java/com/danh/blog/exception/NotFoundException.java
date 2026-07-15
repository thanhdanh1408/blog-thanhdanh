package com.danh.blog.exception;

/**
 * Exception thrown when a requested resource is not found.
 *
 * <p>Used by controllers when a blog post, project, or other
 * resource cannot be located by its identifier.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
public class NotFoundException extends RuntimeException {

    /**
     * Constructs a NotFoundException with the given message.
     *
     * @param message a description of what was not found
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a NotFoundException with a message and cause.
     *
     * @param message a description of what was not found
     * @param cause   the underlying cause of this exception
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
