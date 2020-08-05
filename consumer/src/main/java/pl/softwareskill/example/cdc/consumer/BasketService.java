package pl.softwareskill.example.cdc.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@RequiredArgsConstructor
public class BasketService {

    private final String basketServiceUrl;

    public UUID createBasket() {
        return WebClient.create(basketServiceUrl)
                .post()
                .uri("/basket")
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BasketView.class)
                .block()
                .getBasketId();
    }
}
