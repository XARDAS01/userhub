package tech.spec.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import tech.spec.jpa.model.DbId;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "users")
public class User implements DbId<UUID> {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String firstName;
    private String lastName;
    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;

    private String email;
    private String phoneNumber;

    private boolean disabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Subscription> subscriptions;

    @CreationTimestamp
    private Instant created;
}
