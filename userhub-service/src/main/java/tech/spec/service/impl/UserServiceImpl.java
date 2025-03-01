package tech.spec.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.spec.api.dto.UserDto;
import tech.spec.api.request.UserRegistrationRequest;
import tech.spec.exception.ObjectNotFoundException;
import tech.spec.jpa.model.DbId;
import tech.spec.mapper.UserMapper;
import tech.spec.model.User;
import tech.spec.repository.UserRepository;
import tech.spec.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @NonNull
    public DbId<UUID> registration(@NonNull UserRegistrationRequest userRegistrationRequest) {
        log.info("user saving request");
        return userRepository.save(userMapper.mapToEntity(userRegistrationRequest));
    }

    @Override
    @NonNull
    @Transactional(readOnly = true)
    public UserDto getById(@NonNull UUID id) {
        return userRepository.findById(id)
                .map(userMapper::mapToDto)
                .orElseThrow(() -> new ObjectNotFoundException(User.class));
    }

    @Override
    public void updateById(@NonNull UUID id, @NonNull UserRegistrationRequest userRegistrationRequest) {
        userRepository.findById(id).ifPresentOrElse(user -> {
            userMapper.update(user, userRegistrationRequest);
            log.info("User updated successful");
        }, () -> log.info("User update error"));
    }

    @Override
    public void deleteById(@NonNull UUID id) {
        userRepository.deleteById(id);
    }
}
