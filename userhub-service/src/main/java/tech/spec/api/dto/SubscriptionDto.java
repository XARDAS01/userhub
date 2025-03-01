package tech.spec.api.dto;

import lombok.Data;
import tech.spec.enums.SubscriptionType;

import java.time.Instant;
import java.util.UUID;

@Data
public class SubscriptionDto {

    private UUID id;
    private SubscriptionType type;
    private String details;
    private Instant created;
}
