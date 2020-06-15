package pl.akolata.offer.domain.command;

import lombok.Builder;
import lombok.Value;
import pl.akolata.offer.domain.infrastructure.command.OfferDomainCommand;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class UpdateOfferCommand implements OfferDomainCommand {
    UUID offerUUID;
    String productName;
    BigDecimal amount;
    LocalDateTime updatedAt;
    String updatedBy;
}
