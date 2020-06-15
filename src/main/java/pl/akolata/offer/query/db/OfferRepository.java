package pl.akolata.offer.query.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<Offer> findByUuid(UUID uuid);
}
