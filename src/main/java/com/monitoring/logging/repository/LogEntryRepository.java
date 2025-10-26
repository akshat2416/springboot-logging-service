package com.monitoring.logging.repository;

import com.monitoring.logging.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {

    /**
     * Calculates the average response time from all log entries.
     * @return The average response time in milliseconds, or 0.0 if no entries exist.
     */
    @Query("SELECT COALESCE(AVG(l.responseTime), 0.0) FROM LogEntry l")
    Double findAverageResponseTime();

    /**
     * Counts the number of requests that resulted in a client or server error (status code >= 400).
     * @return The total count of failed requests.
     */
    @Query("SELECT COUNT(l) FROM LogEntry l WHERE l.statusCode >= 400")
    Long countFailedRequests();
}