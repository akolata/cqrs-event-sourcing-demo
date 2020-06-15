package pl.akolata.offer.query.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.akolata.offer.domain.event.OfferCreatedEvent;
import pl.akolata.offer.domain.event.OfferPaidEvent;
import pl.akolata.offer.domain.event.OfferUpdatedEvent;
import pl.akolata.offer.domain.infrastructure.event.OfferEvent;

@Slf4j
@Component
@RequiredArgsConstructor
class OfferEventListener {
    private final OfferReadModelStore readModelStore;

    @EventListener(classes = {OfferEvent.class})
    public void listenOn(OfferEvent event) {
        log.info("Event received: [{}] with UUID [{}] created at [{}]", event.getClass(), event.eventUUID(), event.eventTime());
        if (event instanceof OfferCreatedEvent) {
            readModelStore.createOffer((OfferCreatedEvent) event);
        } else if (event instanceof OfferUpdatedEvent) {
            readModelStore.updateOffer((OfferUpdatedEvent) event);
        } else if (event instanceof OfferPaidEvent) {
            readModelStore.markAsPaid((OfferPaidEvent) event);
        } else {
            throw new IllegalArgumentException(String.format("Event with class [%s] not handled in [%s]", event.getClass(), getClass()));
        }
    }
}
