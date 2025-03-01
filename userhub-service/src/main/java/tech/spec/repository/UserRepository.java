package tech.spec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.spec.model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
