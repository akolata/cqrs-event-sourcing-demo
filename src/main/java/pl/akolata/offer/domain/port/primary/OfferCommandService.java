package pl.akolata.offer.domain.port.primary;

import pl.akolata.offer.domain.command.CreateOfferCommand;
import pl.akolata.offer.domain.command.MarkOfferAsPaidCommand;
import pl.akolata.offer.domain.command.UpdateOfferCommand;

import java.util.UUID;

public interface OfferCommandService {
    UUID createOffer(CreateOfferCommand command);

    void updateOffer(UpdateOfferCommand command);

    void markOfferAsPaid(MarkOfferAsPaidCommand command);
}
