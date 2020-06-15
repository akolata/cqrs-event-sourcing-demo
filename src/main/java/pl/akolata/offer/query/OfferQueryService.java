package pl.akolata.offer.query;

import java.util.Optional;
import java.util.UUID;

public interface OfferQueryService {
    Optional<OfferDto> findByOfferUUID(UUID uuid);
}
