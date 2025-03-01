package tech.spec.service;

import org.springframework.lang.NonNull;
import tech.spec.api.dto.SubscriptionDto;
import tech.spec.api.request.UserSubscribeRequest;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface SubscriptionService {

    void subscribe(@NonNull UserSubscribeRequest userSubscribeRequest);

    @NonNull
    List<SubscriptionDto> subscriptions(@NonNull UUID id);

    void unsubscribe(@NonNull HashMap<UUID, List<UUID>> subscribes);
}
