package pl.akolata.offer.query.db;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.akolata.offer.query.OfferDto;
import pl.akolata.offer.query.OfferQueryService;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
class OfferQueryServiceDb implements OfferQueryService {
    private final OfferRepository offerRepository;
    private final OfferMapperDb offerMapper;

    @Override
    public Optional<OfferDto> findByOfferUUID(UUID uuid) {
        return offerRepository.findByUuid(uuid).map(offerMapper::toOfferDto);
    }
}
