package com.cloudpragma.awsproject.infrastructure.configuration;

import com.cloudpragma.awsproject.domain.api.IUserServicePort;
import com.cloudpragma.awsproject.domain.spi.IUserPersistencePort;
import com.cloudpragma.awsproject.domain.usecase.UseCaseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {


    @Bean
    public IUserServicePort userServicePort(IUserPersistencePort iUserPersistencePort){
        return new UseCaseUser(iUserPersistencePort);
    }

}