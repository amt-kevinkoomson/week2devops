package com.javaupskill.week2devops.controller;

import com.javaupskill.week2devops.model.HealthCheck;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    public static final long startTime = System.currentTimeMillis();
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public HealthCheck healthCheck() {
        long uptime = (System.currentTimeMillis() - startTime)/1000;
        //he
        return HealthCheck.builder()
                .message("Service Running")
                .uptime(uptime)
                .build();
    }
}
