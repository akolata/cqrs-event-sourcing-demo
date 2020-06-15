package pl.akolata.offer.domain.infrastructure.event;

import pl.akolata.infrastructure.uuid.UUIDGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseOfferEvent implements OfferEvent {
    UUID eventUUID;
    LocalDateTime eventTime;

    protected BaseOfferEvent() {
        this.eventUUID = UUIDGenerator.generate();
        this.eventTime = LocalDateTime.now();
    }

    @Override
    public UUID eventUUID() {
        return eventUUID;
    }

    @Override
    public LocalDateTime eventTime() {
        return eventTime;
    }
}
