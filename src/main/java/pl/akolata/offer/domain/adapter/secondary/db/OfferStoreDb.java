package pl.akolata.offer.domain.adapter.secondary.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.akolata.infrastructure.db.EventDescriptor;
import pl.akolata.infrastructure.event.EventSerializer;
import pl.akolata.infrastructure.event.EventStore;
import pl.akolata.offer.domain.infrastructure.event.OfferEvent;
import pl.akolata.offer.domain.port.secondary.OfferStore;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
class OfferStoreDb implements OfferStore {
    private final EventSerializer eventSerializer;
    private final EventStore eventStore;

    @Override
    public void save(OfferEvent event) {
        EventDescriptor eventDescriptor = eventSerializer.serialize(event);
        eventStore.saveEvents(event.offerUUID(), Collections.singletonList(eventDescriptor));
    }

    @Override
    public List<OfferEvent> findByOfferUUIDOrderByCreatedAt(UUID uuid) {
        return eventStore.getEventsForAggregate(uuid).stream()
                .map(eventSerializer::deserialize)
                .map(event -> (OfferEvent) event)
                .collect(Collectors.toList());
    }
}
