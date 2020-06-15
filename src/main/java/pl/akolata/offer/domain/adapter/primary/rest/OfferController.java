package pl.akolata.offer.domain.adapter.primary.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = OfferController.OFFERS_URL)
@RequiredArgsConstructor
class OfferController {
    static final String OFFERS_URL = "/api/offers";
    private static final String OFFER_PATH_PARAM = "/{offerUUID}";
    private static final String OFFER_URL = OFFERS_URL + OFFER_PATH_PARAM;
    private final OfferServiceRest offerService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Void> createOffer(@RequestBody @Valid CreateOfferRequest request) {
        log.info("POST request on [{}]", OFFERS_URL);
        String createdBy = "rest-api-user"; // Can be replaced with Spring Security user
        UUID offerUUID = offerService.createOffer(request, createdBy, LocalDateTime.now());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(OFFER_PATH_PARAM).buildAndExpand(offerUUID).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(
            path = OFFER_URL,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Void> updateOffer(@PathVariable UUID offerUUID, @RequestBody @Valid UpdateOfferRequest request) {
        log.info("PUT request on [{}]", OFFERS_URL + "/" + offerUUID);
        String updatedBy = "rest-api-user"; // Can be replaced with Spring Security user
        offerService.updateOffer(offerUUID, request, updatedBy, LocalDateTime.now());
        return ResponseEntity.ok().build();
    }
}
