package com.monitoring.logging.controller;
import com.monitoring.logging.dto.LogStatsDto;
import com.monitoring.logging.model.LogEntry;
import com.monitoring.logging.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LoggingController {

    @Autowired
    private LoggingService loggingService;




    @GetMapping
    public ResponseEntity<List<LogEntry>> getAllLogs() {
        return ResponseEntity.ok(loggingService.getAllLogs());
    }

    @GetMapping("/stats")
    public ResponseEntity<LogStatsDto> getStats() {
        return ResponseEntity.ok(loggingService.getLogStats());
    }
}