package com.example.demoauthentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    @GetMapping("/authorize")
    public String authorize(@RequestParam("client_id") String clientId, @RequestParam("redirect_url") String redirectUrl, @RequestParam String state, @RequestParam("code_challenge") String codeChallenge) {
        return "sign-in";
    }
    @PostMapping("/login")
    public String signIn(){
        return "";
    }
}
