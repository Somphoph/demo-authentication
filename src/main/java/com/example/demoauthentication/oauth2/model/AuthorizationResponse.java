package com.example.demoauthentication.oauth2.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationResponse {
    private String code;

    private String state;
}
