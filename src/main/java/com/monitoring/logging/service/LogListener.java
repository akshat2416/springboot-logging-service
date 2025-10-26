// src/main/java/com/yourdomain/loggingservice/service/LogListener.java
package com.monitoring.logging.service;

import com.monitoring.logging.dto.LogRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogListener {

    @Autowired
    private LoggingService loggingService;

    public static final String QUEUE_NAME = "logging_queue";

    @RabbitListener(queues = QUEUE_NAME)
    public void receiveLog(LogRequest request) {
        System.out.println("Received log for " + request.getMethod() + " " + request.getEndpoint());
        loggingService.createLog(request);
    }
}