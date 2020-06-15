package pl.akolata.offer.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.akolata.offer.domain.command.CreateOfferCommand;
import pl.akolata.offer.domain.command.MarkOfferAsPaidCommand;
import pl.akolata.offer.domain.command.UpdateOfferCommand;
import pl.akolata.offer.domain.port.primary.OfferCommandService;
import pl.akolata.infrastructure.uuid.UUIDGenerator;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
class CommandService implements OfferCommandService {
    private final OfferService offerService;

    @Override
    public UUID createOffer(CreateOfferCommand command) {
        UUID offerUUID = UUIDGenerator.generate();
        Offer offer = Offer.from(offerUUID);
        offer.create(command.getProductName(), command.getAmount(), command.getCreatedAt(), command.getCreatedBy());
        store(offer);
        log.info("Created new offer with UUID [{}]", offerUUID);
        return offerUUID;
    }

    @Override
    public void updateOffer(UpdateOfferCommand command) {
        Offer offer = loadOffer(command.getOfferUUID());
        offer.update(command.getProductName(), command.getAmount(), command.getUpdatedAt(), command.getUpdatedBy());
        store(offer);
        log.info("Updated offer with UUID [{}]", command.getOfferUUID());
    }

    @Override
    public void markOfferAsPaid(MarkOfferAsPaidCommand command) {
        Offer offer = loadOffer(command.getOfferUUID());
        offer.markAsPaid(command.getPaidAt(), command.getPaidBy());
        store(offer);
        log.info("Offer with UUID [{}] mark as paid", command.getOfferUUID());
    }

    private Offer loadOffer(UUID uuid) {
        return offerService.load(uuid);
    }

    private void store(Offer offer) {
        offerService.store(offer);
    }
}
