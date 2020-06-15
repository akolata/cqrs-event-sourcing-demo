package pl.akolata.offer.domain.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akolata.infrastructure.db.EventDescriptor;
import pl.akolata.offer.domain.infrastructure.event.OfferEvent;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OfferEventSerializer {
    private final ObjectMapper om;

    public EventDescriptor serialize(OfferEvent event) {
        try {
            return new EventDescriptor(om.writeValueAsString(event), event.eventTime(), event.type());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public OfferEvent deserialize(EventDescriptor eventDescriptor) {
        try {
            return om.readValue(eventDescriptor.getBody(), OfferEvent.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
