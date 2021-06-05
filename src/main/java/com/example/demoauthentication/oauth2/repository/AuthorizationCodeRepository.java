package com.example.demoauthentication.oauth2.repository;

import com.example.demoauthentication.oauth2.domain.AuthorizationCode;
import org.springframework.data.repository.CrudRepository;

public interface AuthorizationCodeRepository extends CrudRepository<AuthorizationCode,String> {
}
