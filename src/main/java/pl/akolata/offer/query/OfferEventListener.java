package pl.akolata.offer.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.akolata.offer.domain.infrastructure.event.OfferEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class OfferEventListener {

    @Async
    @EventListener(classes = {OfferEvent.class})
    public void listenOn(OfferEvent event) {
        log.info("Event received: [{}] with UUID [{}] created at [{}]", event.getClass(), event.eventUUID(), event.eventTime());
    }
}
