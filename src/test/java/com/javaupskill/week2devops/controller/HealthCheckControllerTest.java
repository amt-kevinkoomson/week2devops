package com.javaupskill.week2devops.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCheckControllerTest {
    HealthCheckController controller = new HealthCheckController();
    @Test
    void healthCheckTest(){
        assertEquals("Service Running", controller.healthCheck().getMessage());
    }


}