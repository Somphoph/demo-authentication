package com.example.demoauthentication.oauth2.generator;

import com.example.demoauthentication.oauth2.model.AuthorizationRequest;
import com.example.demoauthentication.oauth2.model.AuthorizationResponse;

public interface AuthorizationCodeGenerator {
    AuthorizationResponse generate(AuthorizationRequest req);
}
