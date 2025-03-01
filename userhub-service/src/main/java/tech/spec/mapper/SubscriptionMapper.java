package tech.spec.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tech.spec.api.dto.SubscriptionDto;
import tech.spec.api.request.UserSubscribeRequest;
import tech.spec.model.Subscription;
import tech.spec.model.User;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionDto mapToDto(Subscription source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", source = "source.type")
    @Mapping(target = "details", source = "source.details")
    @Mapping(target = "user", source = "user")
    Subscription mapToEntity(UserSubscribeRequest source, User user);
}
