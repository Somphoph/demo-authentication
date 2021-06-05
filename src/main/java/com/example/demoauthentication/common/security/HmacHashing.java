package com.example.demoauthentication.common.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.codec.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public abstract class HmacHashing implements Hashing {
    private final String hmacAlgorithm;

    private final String privateKey;

    public HmacHashing(String privateKey, String hmacAlgorithm) {
        this.hmacAlgorithm = hmacAlgorithm;
        this.privateKey = privateKey;
    }

    @Override
    public String hash(byte[] data) {
        try {
            if (data == null || data.length == 0) {
                return null;
            }

            SecretKeySpec signingKey = new SecretKeySpec(this.privateKey.getBytes(), hmacAlgorithm);
            Mac mac = Mac.getInstance(hmacAlgorithm);
            mac.init(signingKey);
            return new String(Hex.encode(mac.doFinal(data)));
        } catch (InvalidKeyException | NoSuchAlgorithmException ex) {
            log.warn(null, ex);
            return null;
        }
    }

    @Override
    public boolean matches(byte[] data, String token) {
        if (token == null || data == null || data.length == 0) {
            return false;
        }
        return MessageDigest.isEqual(hash(data).getBytes(), token.getBytes());
    }
}
