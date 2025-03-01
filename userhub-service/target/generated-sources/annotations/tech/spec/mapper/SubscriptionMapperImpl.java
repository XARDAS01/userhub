package tech.spec.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.spec.api.dto.SubscriptionDto;
import tech.spec.api.request.UserSubscribeRequest;
import tech.spec.model.Subscription;
import tech.spec.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T19:47:28+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class SubscriptionMapperImpl implements SubscriptionMapper {

    @Override
    public SubscriptionDto mapToDto(Subscription source) {
        if ( source == null ) {
            return null;
        }

        SubscriptionDto subscriptionDto = new SubscriptionDto();

        subscriptionDto.setId( source.getId() );
        subscriptionDto.setType( source.getType() );
        subscriptionDto.setDetails( source.getDetails() );
        subscriptionDto.setCreated( source.getCreated() );

        return subscriptionDto;
    }

    @Override
    public Subscription mapToEntity(UserSubscribeRequest source, User user) {
        if ( source == null && user == null ) {
            return null;
        }

        Subscription subscription = new Subscription();

        if ( source != null ) {
            subscription.setType( source.type() );
            subscription.setDetails( source.details() );
        }
        if ( user != null ) {
            subscription.setUser( user );
            subscription.setCreated( user.getCreated() );
        }

        return subscription;
    }
}
