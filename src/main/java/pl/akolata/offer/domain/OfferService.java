package pl.akolata.offer.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.akolata.offer.domain.infrastructure.event.OfferEvent;
import pl.akolata.offer.domain.port.secondary.OfferStore;
import pl.akolata.offer.domain.port.shared.OfferNotFoundException;
import pl.akolata.infrastructure.event.DomainEventPublisher;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
class OfferService {
    private final OfferStore offerStore;
    private final DomainEventPublisher eventPublisher;

    void store(Offer offer) {
        List<OfferEvent> pendingEvents = offer.getPendingEvents();
        int noOfEvents = pendingEvents.size();
        pendingEvents.forEach(this::saveAndPublish);
        offer.markEventsAsCommitted();
        log.info("Offer with UUID [{}] stored, [{}] pending events saved and published", offer.getUuid(), noOfEvents);
    }

    Offer load(UUID uuid) {
        List<OfferEvent> events = offerStore.findByOfferUUIDOrderByCreatedAt(uuid);
        if (events.isEmpty()) {
            throw new OfferNotFoundException(String.format("Offer with UUID [%s] not found", uuid));
        }
        log.info("Offer with UUID [{}] loaded from store", uuid);
        return Offer.from(uuid, events);
    }

    private void saveAndPublish(OfferEvent event) {
        offerStore.save(event);
        eventPublisher.publish(event);
    }
}
