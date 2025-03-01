package tech.spec.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.spec.api.dto.SubscriptionDto;
import tech.spec.api.request.UserSubscribeRequest;
import tech.spec.enums.SubscriptionType;
import tech.spec.mapper.SubscriptionMapper;
import tech.spec.repository.SubscriptionRepository;
import tech.spec.repository.UserRepository;
import tech.spec.service.SubscriptionService;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final UserRepository userRepository;

    @Override
    public void subscribe(@NonNull UserSubscribeRequest userSubscribeRequest) {
        userRepository.findById(userSubscribeRequest.userId()).ifPresentOrElse(user -> {
            subscriptionRepository.save(subscriptionMapper.mapToEntity(userSubscribeRequest, user));
            log.info("New subscription for user {} with type {}",
                    userSubscribeRequest.userId(), userSubscribeRequest.type());
        }, () -> log.info("Subscription for user {} with type {} cancelled",
                userSubscribeRequest.userId(), userSubscribeRequest.type()));
    }

    @Override
    @NonNull
    @Transactional(readOnly = true)
    public List<SubscriptionDto> subscriptions(@NonNull UUID id) {
        return subscriptionRepository.findSubscriptionsByUserId(id).stream()
                .map(subscriptionMapper::mapToDto)
                .toList();
    }

    @Override
    public void unsubscribe(@NonNull HashMap<UUID, List<UUID>> subscribes) {
        subscribes.forEach((key, value) -> userRepository.findById(key).ifPresentOrElse(user -> {
            subscriptionRepository.unsubscribe(value);
            log.info("Subscriptions {} cancelled for user {}", value, key);
        }, () -> log.info("Unsubscribe process cancelled {} for user {}", value, key)));
    }

    @Override
    @NonNull
    @Transactional(readOnly = true)
    public List<SubscriptionType> top() {
        return subscriptionRepository.findTopTypes();
    }
}
