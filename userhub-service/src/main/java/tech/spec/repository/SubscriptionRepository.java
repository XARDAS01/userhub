package tech.spec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tech.spec.model.Subscription;

import java.util.List;
import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {

    @Query("select subscription from Subscription subscription where subscription.user.id = :id")
    List<Subscription> findSubscriptionsByUserId(UUID id);

    @Modifying
    @Query("delete from Subscription sub where sub.id in :subscriptions")
    void unsubscribe(List<UUID> subscriptions);
}
