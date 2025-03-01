package tech.spec.api.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
public class UserDto {

    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String phoneNumber;
    private boolean disabled;
    private List<SubscriptionDto> subscriptions;
    private Instant created;
}
