package com.example.demoauthentication.oauth2.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationCode {
    private String userId;

    private String clientId;

    private Date issueAt;

    private Date expireAt;
}
