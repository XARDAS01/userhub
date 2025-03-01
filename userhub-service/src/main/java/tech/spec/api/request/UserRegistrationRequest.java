package tech.spec.api.request;

public record UserRegistrationRequest(
        String username,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
){
}
