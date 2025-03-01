package tech.spec.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import tech.spec.api.dto.UserDto;
import tech.spec.api.request.UserRegistrationRequest;
import tech.spec.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapToDto(User source);

    User mapToEntity(UserRegistrationRequest source);

    void update(@MappingTarget User target, UserRegistrationRequest userRegistrationRequest);
}
