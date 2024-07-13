package com.example.meatshop.security;

import java.security.SecureRandom;

public class SecurityConstants {
    public static final long JWT_EXPIRATION=70000;
    public static final byte[] JWT_SECRET;

    static {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32]; // 256 bits
        random.nextBytes(bytes);
        JWT_SECRET = bytes;
    }
}
