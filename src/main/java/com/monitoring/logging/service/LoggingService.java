// src/main/java/com/yourdomain/loggingservice/service/LoggingService.java
package com.monitoring.logging.service;


import com.monitoring.logging.dto.LogRequest;
import com.monitoring.logging.dto.LogStatsDto;
import com.monitoring.logging.model.LogEntry;
import com.monitoring.logging.repository.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoggingService {

    @Autowired
    private LogEntryRepository logEntryRepository;

    public void createLog(LogRequest request) {
        LogEntry logEntry = new LogEntry();
        logEntry.setEndpoint(request.getEndpoint());
        logEntry.setMethod(request.getMethod());
        logEntry.setStatusCode(request.getStatusCode());
        logEntry.setResponseTime(request.getResponseTime());
        logEntry.setUserId(request.getUserId()); // Can be null
        logEntryRepository.save(logEntry);
    }

    public List<LogEntry> getAllLogs() {
        return logEntryRepository.findAll();
    }

    public LogStatsDto getLogStats() {
        long totalRequests = logEntryRepository.count();
        double avgResponseTime = logEntryRepository.findAverageResponseTime();
        long failedRequests = logEntryRepository.countFailedRequests();
        return new LogStatsDto(totalRequests, avgResponseTime, failedRequests);
    }
}