package pl.akolata.infrastructure.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akolata.infrastructure.db.EventDescriptor;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class EventSerializer {
    private final ObjectMapper om;

    public EventDescriptor serialize(DomainEvent event) {
        try {
            return new EventDescriptor(om.writeValueAsString(event), event.eventTime(), event.type());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public DomainEvent deserialize(EventDescriptor eventDescriptor) {
        try {
            return om.readValue(eventDescriptor.getBody(), DomainEvent.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
