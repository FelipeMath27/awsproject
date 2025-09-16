package com.cloudpragma.awsproject.infrastructure.configuration;

import com.cloudpragma.awsproject.domain.api.IUserServicePort;
import com.cloudpragma.awsproject.domain.spi.IUserPersistencePort;
import com.cloudpragma.awsproject.domain.usecase.UseCaseUser;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Objects;
import java.util.Properties;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        Dotenv dotenv = Dotenv.load();
        Properties props = new Properties();
        dotenv.entries().forEach(dotenvEntry ->
                props.put(
                        dotenvEntry.getKey(),
                        dotenvEntry.getValue()
                )
        );

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setProperties(props);
        return configurer;
    }

    @Bean
    public IUserServicePort userServicePort(IUserPersistencePort iUserPersistencePort){
        return new UseCaseUser(iUserPersistencePort);
    }

}
