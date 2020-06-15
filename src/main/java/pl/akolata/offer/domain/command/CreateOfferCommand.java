package pl.akolata.offer.domain.command;

import lombok.Builder;
import lombok.Value;
import pl.akolata.offer.domain.infrastructure.command.OfferDomainCommand;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@Builder
public class CreateOfferCommand implements OfferDomainCommand {
    String productName;
    BigDecimal amount;
    LocalDateTime createdAt;
    String createdBy;
}
