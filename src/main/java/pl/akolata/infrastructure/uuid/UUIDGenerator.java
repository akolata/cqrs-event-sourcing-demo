package pl.akolata.infrastructure.uuid;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class UUIDGenerator {
    public UUID generate() {
        return UUID.randomUUID();
    }
}
