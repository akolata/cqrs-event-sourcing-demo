package pl.akolata.offer.query;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OfferDto {
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
