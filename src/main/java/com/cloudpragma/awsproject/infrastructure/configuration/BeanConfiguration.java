package com.cloudpragma.awsproject.infrastructure.configuration;

import com.cloud.awsprj.domain.api.IUserServicePort;
import com.cloud.awsprj.domain.spi.IUserPersistencePort;
import com.cloud.awsprj.domain.usecase.UseCaseUser;
import com.cloud.awsprj.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {
    private final IUserRepository iuserRepository;

    @Bean
    public IUserServicePort userServicePort(IUserPersistencePort iUserPersistencePort){
        return new UseCaseUser(iUserPersistencePort);
    }

}
