package tech.spec.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import tech.spec.exception.UserhubGlobalExceptionHandler;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserhubGlobalExceptionHandler userhubGlobalException(Environment environment) {
        return new UserhubGlobalExceptionHandler();
    }
}
