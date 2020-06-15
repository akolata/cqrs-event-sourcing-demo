package pl.akolata.offer.domain.infrastructure.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import pl.akolata.offer.domain.event.OfferCreatedEvent;
import pl.akolata.offer.domain.event.OfferPaidEvent;
import pl.akolata.offer.domain.event.OfferUpdatedEvent;
import pl.akolata.infrastructure.event.DomainEvent;

import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = OfferCreatedEvent.TYPE, value = OfferCreatedEvent.class),
        @JsonSubTypes.Type(name = OfferUpdatedEvent.TYPE, value = OfferUpdatedEvent.class),
        @JsonSubTypes.Type(name = OfferPaidEvent.TYPE, value = OfferPaidEvent.class)
})
public interface OfferEvent extends DomainEvent {
    /**
     * @return uuid of an offer aggregate
     */
    UUID offerUUID();
}
