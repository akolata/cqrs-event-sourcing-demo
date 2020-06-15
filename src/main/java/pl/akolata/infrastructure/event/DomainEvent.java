package pl.akolata.infrastructure.event;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
    /**
     * @return UUID of an event
     */
    UUID eventUUID();

    /**
     * @return time of an event
     */
    LocalDateTime eventTime();

    /**
     * @return type of an event
     */
    String type();
}
