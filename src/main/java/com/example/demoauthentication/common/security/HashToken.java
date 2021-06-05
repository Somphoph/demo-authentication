package com.example.demoauthentication.common.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDateTime;

public interface HashToken {
    String hash(UserDetails userDetails, LocalDateTime expires);

    boolean matches(String token, UserDetailsService service);
}
