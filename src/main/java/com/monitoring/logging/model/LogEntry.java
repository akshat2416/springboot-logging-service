package com.monitoring.logging.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "api_logs")
@Getter
@Setter
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String endpoint;

    @Column(nullable = false)
    private String method;

    @Column(name = "status_code", nullable = false)
    private Integer statusCode;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "response_time_ms", nullable = false)
    private Long responseTime;

    @Column(name = "user_id")
    private String userId; // Optional, can be null

    @PrePersist
    public void onPrePersist() {
        timestamp = LocalDateTime.now();
    }
}