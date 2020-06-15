package pl.akolata.offer.domain.event;

import lombok.EqualsAndHashCode;
import lombok.Value;
import pl.akolata.offer.domain.infrastructure.event.BaseOfferEvent;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = true)
public class OfferUpdatedEvent extends BaseOfferEvent {
    public static final String TYPE = "offer.updated";

    UUID offerUUID;
    String productName;
    BigDecimal amount;
    LocalDateTime updatedAt;
    String updatedBy;

    public OfferUpdatedEvent(UUID offerUUID, String productName, BigDecimal amount, LocalDateTime updatedAt, String updatedBy) {
        this.offerUUID = offerUUID;
        this.productName = productName;
        this.amount = amount;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
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
