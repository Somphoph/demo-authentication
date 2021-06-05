package com.example.demoauthentication.common.security;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HmacSHA256Hashing extends HmacHashing implements Hashing {

    public HmacSHA256Hashing(String privateKey) {
        super(privateKey,"HmacSHA256");
    }


}
