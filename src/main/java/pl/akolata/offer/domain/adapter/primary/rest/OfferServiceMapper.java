package pl.akolata.offer.domain.adapter.primary.rest;

import org.mapstruct.Mapper;
import pl.akolata.offer.domain.command.CreateOfferCommand;
import pl.akolata.offer.domain.command.UpdateOfferCommand;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper
interface OfferServiceMapper {
    CreateOfferCommand toCreateOfferCommand(CreateOfferRequest request, String createdBy, LocalDateTime createdAt);

    UpdateOfferCommand toUpdateOfferCommand(UpdateOfferRequest request, UUID offerUUID, String updatedBy, LocalDateTime updatedAt);
}
