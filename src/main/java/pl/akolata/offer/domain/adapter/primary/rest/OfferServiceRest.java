package pl.akolata.offer.domain.adapter.primary.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akolata.offer.domain.command.CreateOfferCommand;
import pl.akolata.offer.domain.command.UpdateOfferCommand;
import pl.akolata.offer.domain.port.primary.OfferCommandService;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
class OfferServiceRest {
    private final OfferCommandService offerCommandService;
    private final OfferServiceMapper offerMapper;

    UUID createOffer(CreateOfferRequest request, String createdBy, LocalDateTime createdAt) {
        CreateOfferCommand command = offerMapper.toCreateOfferCommand(request, createdBy, createdAt);
        return offerCommandService.createOffer(command);
    }

    void updateOffer(UUID offerUUID, UpdateOfferRequest request, String updatedBy, LocalDateTime updatedAt) {
        UpdateOfferCommand command = offerMapper.toUpdateOfferCommand(request, offerUUID, updatedBy, updatedAt);
    }
}
