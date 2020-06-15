package pl.akolata.infrastructure.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akolata.infrastructure.db.EventDescriptor;
import pl.akolata.infrastructure.db.EventStream;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventStore extends JpaRepository<EventStream, Long> {
    Optional<EventStream> findByUuid(UUID uuid);

    default void saveEvents(UUID aggregateId, List<EventDescriptor> events) {
        final EventStream eventStream = findByUuid(aggregateId)
                .orElseGet(() -> new EventStream(aggregateId));
        eventStream.addEvents(events);
        save(eventStream);
    }

    default List<EventDescriptor> getEventsForAggregate(UUID aggregateId) {
        return findByUuid(aggregateId)
                .map(EventStream::getEvents)
                .orElse(Collections.emptyList());
    }
}
