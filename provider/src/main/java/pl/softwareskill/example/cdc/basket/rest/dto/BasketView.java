package pl.softwareskill.example.cdc.basket.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BasketView {

    private UUID basketId;
}
