package pl.akolata.offer.domain.adapter.primary.rest;

import org.mapstruct.Mapper;
import pl.akolata.offer.domain.command.CreateOfferCommand;
import pl.akolata.offer.domain.command.UpdateOfferCommand;
import pl.akolata.offer.query.OfferDto;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper
interface OfferMapperRest {
    CreateOfferCommand toCreateOfferCommand(CreateOfferRequest request, String createdBy, LocalDateTime createdAt);

    UpdateOfferCommand toUpdateOfferCommand(UpdateOfferRequest request, UUID offerUUID, String updatedBy, LocalDateTime updatedAt);

    OfferResponse toOfferResponse(OfferDto offerDto);
}
