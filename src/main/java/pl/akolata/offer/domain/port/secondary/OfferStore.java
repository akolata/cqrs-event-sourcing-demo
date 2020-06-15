package pl.akolata.offer.domain.port.secondary;

import pl.akolata.offer.domain.infrastructure.event.OfferEvent;

import java.util.List;
import java.util.UUID;

public interface OfferStore {
    void save(OfferEvent event);

    List<OfferEvent> findByOfferUUIDOrderByCreatedAt(UUID uuid);
}
