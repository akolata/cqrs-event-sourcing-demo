package pl.akolata.offer.query.db;

import org.mapstruct.Mapper;
import pl.akolata.offer.query.OfferDto;

@Mapper
interface OfferMapperDb {
    OfferDto toOfferDto(Offer offer);
}
