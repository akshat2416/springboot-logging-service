
package com.monitoring.logging.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogStatsDto {
    private long totalRequests;
    private double averageResponseTimeMs;
    private long failedRequests;
}