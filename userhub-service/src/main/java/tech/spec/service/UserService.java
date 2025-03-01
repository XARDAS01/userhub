package tech.spec.service;

import org.springframework.lang.NonNull;
import tech.spec.api.dto.UserDto;
import tech.spec.api.request.UserRegistrationRequest;
import tech.spec.jpa.model.DbId;

import java.util.UUID;

public interface UserService {

    @NonNull
    DbId<UUID> registration(@NonNull UserRegistrationRequest userRegistrationRequest);

    UserDto getById(@NonNull UUID id);

    void updateById(@NonNull UUID id, @NonNull UserRegistrationRequest userRegistrationRequest);

    void deleteById(@NonNull UUID id);
}
