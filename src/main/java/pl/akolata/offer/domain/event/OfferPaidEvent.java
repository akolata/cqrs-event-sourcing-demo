package pl.akolata.offer.domain.event;

import lombok.EqualsAndHashCode;
import lombok.Value;
import pl.akolata.offer.domain.infrastructure.event.BaseOfferEvent;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@EqualsAndHashCode(callSuper = true)
public class OfferPaidEvent extends BaseOfferEvent {
    public static final String TYPE = "offer.paid";

    UUID offerUUID;
    LocalDateTime paidAt;
    String paidBy;

    public OfferPaidEvent(UUID offerUUID, LocalDateTime paidAt, String paidBy) {
        this.offerUUID = offerUUID;
        this.paidAt = paidAt;
        this.paidBy = paidBy;
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
