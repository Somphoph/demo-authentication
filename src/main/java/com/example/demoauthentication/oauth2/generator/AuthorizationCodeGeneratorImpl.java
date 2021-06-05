package com.example.demoauthentication.oauth2.generator;

import com.example.demoauthentication.common.security.DefaultUserDetails;
import com.example.demoauthentication.common.security.HashToken;
import com.example.demoauthentication.oauth2.domain.AuthorizationCode;
import com.example.demoauthentication.oauth2.model.AuthorizationRequest;
import com.example.demoauthentication.oauth2.model.AuthorizationResponse;
import com.example.demoauthentication.oauth2.repository.AuthorizationCodeRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuthorizationCodeGeneratorImpl implements AuthorizationCodeGenerator {

    private AuthorizationCodeRepository authorizationCodeRepository;
    private HashToken hashBasedToken;

    public AuthorizationCodeGeneratorImpl(AuthorizationCodeRepository authorizationCodeRepository, HashToken hashBasedToken) {
        this.authorizationCodeRepository = authorizationCodeRepository;
        this.hashBasedToken = hashBasedToken;
    }

    @Override
    public AuthorizationResponse generate(AuthorizationRequest req) {
        AuthorizationCode code = generateAuthorizationCode(req);
        return AuthorizationResponse.builder()
                .code(hashToken(code))
                .state(req.getState())
                .build();
    }

    private String hashToken(AuthorizationCode code) {
//        return hashBasedToken.hash(
//                DefaultUserDetails.builder()
//                        .username(code.getTokenId())
//                        .password(code.getSecretKey())
//                        .build(),
//                convert2LocalDateTime(code.getExpireAt())
//        );
        return "";
    }

    private AuthorizationCode generateAuthorizationCode(AuthorizationRequest req) {
        return authorizationCodeRepository.save(AuthorizationCode.builder()
//                .userId(loginSession.getUserDetails().getUsername())
                .clientId(req.getClientId())
//                .sessionId(loginSession.getSessionId())
                .build()
        );
    }

}
