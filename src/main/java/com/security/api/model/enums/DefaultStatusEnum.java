package com.security.api.model.enums;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Arrays;

public enum DefaultStatusEnum {
    ACTIVE(0, "Ativo"),
    INACTIVE(1, "Inativo");

    private int value;

    private String initials;

    private static ImmutableMap<Integer, DefaultStatusEnum> reverseLookupValue =
        Maps.uniqueIndex(Arrays.asList(DefaultStatusEnum.values()), DefaultStatusEnum::getValue);

    private static ImmutableMap<String, DefaultStatusEnum> reverseLookupInitials =
        Maps.uniqueIndex(Arrays.asList(DefaultStatusEnum.values()), DefaultStatusEnum::getInitials);

    private DefaultStatusEnum(int value, String initials) {
        this.value = value;
        this.initials = initials;
    }

    public int getValue() {
        return value;
    }

    public String getInitials() {
        return initials;
    }

    public static DefaultStatusEnum fromValue(final int value) {
        return reverseLookupValue.getOrDefault(value, ACTIVE);
    }

    public static DefaultStatusEnum fromInitials(final String initials) {
        return reverseLookupInitials.getOrDefault(initials, ACTIVE);
    }

    public static DefaultStatusEnum existFromInitials(final String initials) {
        return reverseLookupInitials.get(initials);
    }
}
