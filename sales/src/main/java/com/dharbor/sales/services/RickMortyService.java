package com.dharbor.sales.services;

import com.dharbor.sales.clients.RickMortyApiFeignClient;
import com.dharbor.sales.model.rest.Character;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Josue Veliz
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RickMortyService {

    private final RickMortyApiFeignClient rickMortyApiFeignClient;

    @CircuitBreaker(name = "rickMortyService", fallbackMethod = "fallbackGetCharacter")
    public Character getCharacter() {
        return rickMortyApiFeignClient.findById(2);
    }

    public Character fallbackGetCharacter(Throwable t) {
        log.error("Rick and Morty API unavailable: {}", t.getMessage());
        return new Character(1, "Rick (Default)", "Unknown", "Unknown");
    }
}
