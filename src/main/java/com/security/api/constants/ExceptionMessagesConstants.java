package com.security.api.constants;

public class ExceptionMessagesConstants {
    private ExceptionMessagesConstants() {
        throw new IllegalStateException(ExceptionMessagesConstants.UTILITY_CLASS);
    }

    public static final String UTILITY_CLASS = "Classe de utilidade";
    public static final String ERROR_GENERATION_TOKEN = "Error while generation token";
}