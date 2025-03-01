package tech.spec.api.request;

import tech.spec.enums.SubscriptionType;

import java.util.UUID;

public record UserSubscribeRequest(
        UUID userId,
        SubscriptionType type,
        String details
) {
}
