package pl.akolata.offer.domain.event;

import lombok.EqualsAndHashCode;
import lombok.Value;
import pl.akolata.offer.domain.infrastructure.event.BaseOfferEvent;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = true)
public class OfferCreatedEvent extends BaseOfferEvent {
    public static final String TYPE = "offer.created";

    UUID offerUUID;
    String productName;
    BigDecimal amount;
    LocalDateTime createdAt;
    String createdBy;

    public OfferCreatedEvent(UUID offerUUID, String productName, BigDecimal amount, LocalDateTime createdAt, String createdBy) {
        this.offerUUID = offerUUID;
        this.productName = productName;
        this.amount = amount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    @Override
    public String type() {
        return TYPE;
    }

    @Override
    public UUID offerUUID() {
        return offerUUID;
    }

}
