package com.example.demoauthentication;

import com.example.demoauthentication.common.security.DefaultHashToken;
import com.example.demoauthentication.common.security.HashToken;
import com.example.demoauthentication.common.security.Hashing;
import com.example.demoauthentication.common.security.HmacSHA256Hashing;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @NotNull
    @Value("${spring.token.secretKey}")
    private String tokenSecretKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/authorize").permitAll();
    }

    @Bean
    public HashToken newHashBasedToken() {
        return new DefaultHashToken(newHashing());
    }

    @Bean
    public Hashing newHashing() {
        return new HmacSHA256Hashing(tokenSecretKey);
    }
}
