package com.example.demoauthentication.oauth2.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizationRequest {
    private String responseType;
    private String clientId;
    private String redirectUri;
    private String scope;
    private String state;
}
