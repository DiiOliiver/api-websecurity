package com.security.api.model.enums;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Arrays;

public enum UserRoleEnum {
    ADMIN(0, "Admin"),
    USER(1, "User");

    private int value;

    private String initials;

    private static ImmutableMap<Integer, UserRoleEnum> reverseLookupValue =
        Maps.uniqueIndex(Arrays.asList(UserRoleEnum.values()), UserRoleEnum::getValue);

    private static ImmutableMap<String, UserRoleEnum> reverseLookupInitials =
        Maps.uniqueIndex(Arrays.asList(UserRoleEnum.values()), UserRoleEnum::getInitials);

    private UserRoleEnum(int value, String initials) {
        this.value = value;
        this.initials = initials;
    }

    public int getValue() {
        return value;
    }

    public String getInitials() {
        return initials;
    }

    public static UserRoleEnum fromValue(final int value) {
        return reverseLookupValue.getOrDefault(value, USER);
    }

    public static UserRoleEnum fromInitials(final String initials) {
        return reverseLookupInitials.getOrDefault(initials, USER);
    }

    public static UserRoleEnum existFromInitials(final String initials) {
        return reverseLookupInitials.get(initials);
    }
}
