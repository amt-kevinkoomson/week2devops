package com.javaupskill.week2devops.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HealthCheck {
    private String message;
    private Long uptime;
}
