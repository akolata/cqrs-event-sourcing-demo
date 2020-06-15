package pl.akolata.offer.domain.adapter.primary.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.akolata.offer.query.OfferStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
class OfferResponse {
    private UUID uuid;
    private String productName;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private LocalDateTime paidAt;
    private String paidBy;
    private OfferStatus status;
    private Long version;
}
