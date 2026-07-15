package com.danh.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global exception handler for the application.
 *
 * <p>Catches exceptions thrown by any controller and renders
 * user-friendly error pages instead of stack traces.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles NotFoundException by rendering a custom 404 page.
     *
     * @param ex    the NotFoundException that was thrown
     * @param model the Spring MVC model
     * @return the 404 error page template name
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(NotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error/404";
    }

    /**
     * Handles all other unhandled exceptions with a generic error page.
     *
     * @param ex    the exception that was thrown
     * @param model the Spring MVC model
     * @return the generic error page template name
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGenericError(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Đã xảy ra lỗi không mong muốn. Vui lòng thử lại sau.");
        return "error/error";
    }

}
