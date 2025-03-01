package tech.spec.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import tech.spec.enums.SubscriptionType;
import tech.spec.jpa.model.DbId;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "subscriptions")
public class Subscription implements DbId<UUID> {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    private SubscriptionType type;
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private Instant created;
}
