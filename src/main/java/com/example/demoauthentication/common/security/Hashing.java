package com.example.demoauthentication.common.security;

public interface Hashing {
    String hash(byte[] data);

    boolean matches(byte[] data, String token);
}
