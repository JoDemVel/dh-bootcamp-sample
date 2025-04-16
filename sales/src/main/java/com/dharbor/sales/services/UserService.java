package com.dharbor.sales.services;

import com.dharbor.sales.clients.UsersFeignClient;
import com.dharbor.sales.model.User;
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
public class UserService {

    private final UsersFeignClient usersFeignClient;

    @CircuitBreaker(name = "usersService", fallbackMethod = "fallbackFindById")
    public User findById(UUID userId) {
        return usersFeignClient.findById(userId);
    }

    public User fallbackFindById(UUID userId, Throwable t) {
        log.error("User service unavailable: {}", t.getMessage());
        return new User(userId, "Unknown", "unknown@example.com");
    }
}
