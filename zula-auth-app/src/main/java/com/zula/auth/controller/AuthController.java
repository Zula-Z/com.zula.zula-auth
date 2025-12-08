package com.zula.auth.controller;

import com.zula.auth.service.AuthMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthMessagePublisher authMessagePublisher;

    @GetMapping("/health")
    public String health() {
        return "Zula Auth Service is healthy!";
    }

    @GetMapping("/info")
    public Map<String, Object> getServiceInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("service", "zula-auth");
        info.put("status", "ACTIVE");
        info.put("message", "Authentication service ready");
        info.put("features", new String[]{
                "User authentication",
                "JWT token generation",
                "Message publishing",
                "Admin commands"
        });
        return info;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String requestId = UUID.randomUUID().toString();

        Map<String, String> response = new HashMap<>();
        response.put("message", "Login processed");
        response.put("requestId", requestId);
        response.put("status", "SUCCESS");

        return response;
    }

    @PostMapping("/logout")
    public Map<String, String> logout(@RequestBody Map<String, String> logoutRequest) {
        String username = logoutRequest.get("username");

        Map<String, String> response = new HashMap<>();
        response.put("message", "Logout processed");
        response.put("status", "SUCCESS");

        return response;
    }

    @PostMapping("/test-auth")
    public Map<String, String> testAuth() {
        String requestId = UUID.randomUUID().toString();

        Map<String, String> response = new HashMap<>();
        response.put("message", "Test authentication completed");
        response.put("requestId", requestId);
        response.put("status", "SUCCESS");

        return response;
    }
}