package pl.akolata.offer.query.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.akolata.offer.domain.event.OfferCreatedEvent;
import pl.akolata.offer.domain.event.OfferPaidEvent;
import pl.akolata.offer.domain.event.OfferUpdatedEvent;
import pl.akolata.offer.query.OfferStatus;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
class OfferReadModelStore {
    private final OfferRepository offerRepository;

    @Transactional
    public void createOffer(OfferCreatedEvent event) {
        Offer offer = new Offer();
        offer.setUuid(event.getOfferUUID());
        offer.setProductName(event.getProductName());
        offer.setAmount(event.getAmount());
        offer.setCreatedAt(event.getCreatedAt());
        offer.setCreatedBy(event.getCreatedBy());
        offer.setUpdatedAt(event.getCreatedAt());
        offer.setUpdatedBy(event.getCreatedBy());
        offer.setStatus(OfferStatus.NEW);
        offer.setLastEventUUID(event.eventUUID());
        offerRepository.saveAndFlush(offer);
        log.info("Offer read model for offer with UUID [{}] created", event.getOfferUUID());
    }

    @Transactional
    public void updateOffer(OfferUpdatedEvent event) {
        Offer offer = offerRepository.findByUuid(event.getOfferUUID()).orElseThrow();
        offer.setProductName(event.getProductName());
        offer.setAmount(event.getAmount());
        offer.setUpdatedAt(event.getUpdatedAt());
        offer.setUpdatedBy(event.getUpdatedBy());
        offer.setLastEventUUID(event.eventUUID());
        log.info("Updated offer read model of offer with UUID [{}]", event.getOfferUUID());
    }

    @Transactional
    public void markAsPaid(OfferPaidEvent event) {
        Offer offer = offerRepository.findByUuid(event.getOfferUUID()).orElseThrow();
        offer.setPaidAt(event.getPaidAt());
        offer.setPaidBy(event.getPaidBy());
        offer.setUpdatedAt(LocalDateTime.now());
        offer.setUpdatedBy(event.getPaidBy());
        offer.setLastEventUUID(event.eventUUID());
        offer.setStatus(OfferStatus.PAID);
        log.info("Offer read model with UUID [{}] marked as paid", event.getOfferUUID());
    }
}
