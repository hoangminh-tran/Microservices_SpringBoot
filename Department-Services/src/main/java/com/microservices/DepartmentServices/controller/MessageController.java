package com.microservices.DepartmentServices.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RefreshScope
public class MessageController {
    @Value("${spring.boot.message}")
    private String messaage;

    @GetMapping("/message")
    public ResponseEntity<String> getMessage()
    {
        return new ResponseEntity<>(messaage, HttpStatus.OK);
    }
}
