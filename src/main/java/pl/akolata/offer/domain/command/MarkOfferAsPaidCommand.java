package pl.akolata.offer.domain.command;

import lombok.Builder;
import lombok.Value;
import pl.akolata.offer.domain.infrastructure.command.OfferDomainCommand;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class MarkOfferAsPaidCommand implements OfferDomainCommand {
    UUID offerUUID;
    LocalDateTime paidAt;
    String paidBy;
}
