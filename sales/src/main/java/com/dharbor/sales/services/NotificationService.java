package com.dharbor.sales.services;

import com.dharbor.sales.clients.NotificationsFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Josue Veliz
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationsFeignClient notificationsFeignClient;

    @CircuitBreaker(name = "notificationService", fallbackMethod = "fallbackNotify")
    public String notify(UUID userId) {
        return notificationsFeignClient.sendNotification(userId.toString());
    }

    public String fallbackNotify(UUID userId, Throwable t) {
        log.error("Notification service unavailable: {}", t.getMessage());
        return "notification-failed";
    }
}
