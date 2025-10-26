// src/main/java/com/yourdomain/loggingservice/dto/LogRequest.java
package com.monitoring.logging.dto;

import lombok.Data;

@Data
public class LogRequest {
    private String endpoint;
    private String method;
    private Integer statusCode;
    private Long responseTime;
    private String userId;
}