package pl.akolata.offer.domain.port.shared;

public class OfferNotFoundException extends RuntimeException {

    public OfferNotFoundException(String message) {
        super(message);
    }
}
