package pl.softwareskill.example.cdc.basket.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BasketSummaryView {

    private BigDecimal totalPrice;
}
