package pl.akolata.infrastructure.event;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
