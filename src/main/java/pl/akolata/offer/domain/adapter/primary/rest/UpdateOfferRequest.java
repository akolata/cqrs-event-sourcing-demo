package pl.akolata.offer.domain.adapter.primary.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
class UpdateOfferRequest {
    @NotEmpty
    private String productName;
    @NotNull
    private BigDecimal amount;
}
