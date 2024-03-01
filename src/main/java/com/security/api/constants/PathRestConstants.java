package com.security.api.constants;

public class PathRestConstants {
    private PathRestConstants() {
        throw new IllegalStateException(ExceptionMessagesConstants.UTILITY_CLASS);
    }

    public static final String AUTH = "auth";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";
    public static final String PRODUCT = "product";
}
