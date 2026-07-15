package com.danh.blog.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Utility class providing common helper methods.
 *
 * <p>Contains static utility methods used across the application
 * for formatting, validation, and other common operations.
 *
 * @author Phan Thanh Danh
 * @version 1.0.0
 */
public final class FileUtil {

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.of("vi", "VN"));

    /**
     * Private constructor to prevent instantiation.
     */
    private FileUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Formats a LocalDate into a human-readable Vietnamese date string.
     *
     * @param date the date to format
     * @return the formatted date string, or empty string if date is null
     */
    public static String formatDate(LocalDate date) {
        if (date == null) {
            return "";
        }
        return date.format(DATE_FORMATTER);
    }

    /**
     * Truncates a string to a maximum length, adding ellipsis if needed.
     *
     * @param text      the text to truncate
     * @param maxLength the maximum length
     * @return the truncated text with ellipsis, or original if shorter
     */
    public static String truncate(String text, int maxLength) {
        if (text == null || text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength) + "...";
    }

}
