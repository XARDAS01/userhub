package tech.spec.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        enableDefaultTransactions = false,
        basePackages = "tech.spec.repository"
)
public class JpaConfiguration {
}
