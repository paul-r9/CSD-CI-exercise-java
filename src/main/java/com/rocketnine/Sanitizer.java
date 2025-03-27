package com.rocketnine;

public class Sanitizer {

    public static String sanitize(String unsanitized){
        String sanitized = unsanitized.replace(" ", "");
        sanitized = sanitized.replace("-", "");
        return sanitized;
    }
}
