package pl.akolata.offer.domain.port.shared;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OfferDto {
    UUID offerId;
    String productName;
    BigDecimal amount;
    LocalDateTime createdAt;
    String createdBy;
    OfferState status;
}
