package pl.softwareskill.example.cdc.basket.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.softwareskill.example.cdc.basket.rest.dto.BasketSummaryDto;
import pl.softwareskill.example.cdc.basket.rest.dto.BasketSummaryView;
import pl.softwareskill.example.cdc.basket.rest.dto.BasketView;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/basket")
public class BasketController {

    @PostMapping
    public ResponseEntity<BasketView> createBasket() {
        // Basket basket = basketService.createBasket();
        UUID basketId = UUID.randomUUID();

        return ResponseEntity.created(URI.create("/" + basketId + "/summary"))
                .body(BasketView.builder()
                        .basketId(basketId)
                        .build());
    }

    @PostMapping("/{basketId}/summary")
    public ResponseEntity<BasketSummaryView> summary(@PathVariable UUID basketId,
                                                     @RequestBody BasketSummaryDto basketSummaryView) {
        BigDecimal summaryPrice = BigDecimal.TEN;
        return ResponseEntity.ok(BasketSummaryView.builder()
                .totalPrice(summaryPrice)
                .build());
    }
}
