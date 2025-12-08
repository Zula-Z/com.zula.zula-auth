package com.zula.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZulaAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZulaAuthApplication.class, args);
        System.out.println("Zula Auth Service Started!");
        System.out.println("REST API: http://localhost:8081");
        System.out.println("Auto-queue management enabled");
        System.out.println("Ready for message processing!");
    }
}