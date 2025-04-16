package com.dharbor.sales.services;

import com.dharbor.sales.clients.NotificationsFeignClient;
import com.dharbor.sales.clients.RickMortyApiFeignClient;
import com.dharbor.sales.clients.StockFeignClient;
import com.dharbor.sales.clients.UsersFeignClient;
import com.dharbor.sales.model.User;
import com.dharbor.sales.model.dto.NewSaleDto;
import com.dharbor.sales.model.rest.Character;
import com.dharbor.sales.model.rest.ProductReservationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewSalesService {

    private final UserService userService;

    private final StockService stockService;

    private final NotificationService notificationService;

    private final RickMortyService rickMortyService;

    //TODO: Apply circuit breaking and error handling for Wed 4/16/2025
    public String newSale(NewSaleDto dto) {
        User user = userService.findById(dto.getUserId());
        String reservationId = stockService.reserve(dto.getProductId(), dto.getQuantity());
        String notification = notificationService.notify(dto.getUserId());
        Character character = rickMortyService.getCharacter();

        log.info("Character used: {} - {} - {}", character.getName(), character.getSpecies(), character.getStatus());

        return String.format("New Sale for %s with reservation id %s and user has been notified %s",
                user.getName(), reservationId, notification);
    }
}