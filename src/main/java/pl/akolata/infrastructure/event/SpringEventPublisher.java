package pl.akolata.infrastructure.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
class SpringEventPublisher implements DomainEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publish(DomainEvent event) {
        eventPublisher.publishEvent(event);
        log.info("Event [{}] with UUID [{}] published at [{}]", event.getClass(), event.eventUUID(), LocalDateTime.now());
    }
}
