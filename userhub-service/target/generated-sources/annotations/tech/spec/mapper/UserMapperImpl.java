package tech.spec.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.spec.api.dto.SubscriptionDto;
import tech.spec.api.dto.UserDto;
import tech.spec.api.request.UserRegistrationRequest;
import tech.spec.model.Subscription;
import tech.spec.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T20:05:56+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto mapToDto(User source) {
        if ( source == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( source.getId() );
        userDto.setUsername( source.getUsername() );
        userDto.setFirstName( source.getFirstName() );
        userDto.setLastName( source.getLastName() );
        userDto.setFullName( source.getFullName() );
        userDto.setEmail( source.getEmail() );
        userDto.setPhoneNumber( source.getPhoneNumber() );
        userDto.setDisabled( source.isDisabled() );
        userDto.setSubscriptions( subscriptionListToSubscriptionDtoList( source.getSubscriptions() ) );
        userDto.setCreated( source.getCreated() );

        return userDto;
    }

    @Override
    public User mapToEntity(UserRegistrationRequest source) {
        if ( source == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( source.username() );
        user.setFirstName( source.firstName() );
        user.setLastName( source.lastName() );
        user.setEmail( source.email() );
        user.setPhoneNumber( source.phoneNumber() );

        return user;
    }

    @Override
    public void update(User target, UserRegistrationRequest userRegistrationRequest) {
        if ( userRegistrationRequest == null ) {
            return;
        }

        target.setUsername( userRegistrationRequest.username() );
        target.setFirstName( userRegistrationRequest.firstName() );
        target.setLastName( userRegistrationRequest.lastName() );
        target.setEmail( userRegistrationRequest.email() );
        target.setPhoneNumber( userRegistrationRequest.phoneNumber() );
    }

    protected SubscriptionDto subscriptionToSubscriptionDto(Subscription subscription) {
        if ( subscription == null ) {
            return null;
        }

        SubscriptionDto subscriptionDto = new SubscriptionDto();

        subscriptionDto.setId( subscription.getId() );
        subscriptionDto.setType( subscription.getType() );
        subscriptionDto.setDetails( subscription.getDetails() );
        subscriptionDto.setCreated( subscription.getCreated() );

        return subscriptionDto;
    }

    protected List<SubscriptionDto> subscriptionListToSubscriptionDtoList(List<Subscription> list) {
        if ( list == null ) {
            return null;
        }

        List<SubscriptionDto> list1 = new ArrayList<SubscriptionDto>( list.size() );
        for ( Subscription subscription : list ) {
            list1.add( subscriptionToSubscriptionDto( subscription ) );
        }

        return list1;
    }
}
