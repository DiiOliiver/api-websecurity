package com.security.api.utils;

import java.util.UUID;

public final class UuidHelper {

    public static UUID generateUniqueUUID() {
        long mostSignificantBits = System.currentTimeMillis();
        long leastSignificantBits = UUID.randomUUID().getLeastSignificantBits();
        return new UUID(mostSignificantBits, leastSignificantBits);
    }
}
