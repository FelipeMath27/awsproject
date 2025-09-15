package com.cloudpragma.awsproject.infrastructure.output.jpa.adapter;

import com.cloudpragma.awsproject.domain.model.User;
import com.cloudpragma.awsproject.domain.spi.IUserPersistencePort;
import com.cloudpragma.awsproject.infrastructure.constant.ConstantInfrastructure;
import com.cloudpragma.awsproject.infrastructure.exceptions.InfrastructureException;
import com.cloudpragma.awsproject.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.cloudpragma.awsproject.infrastructure.output.jpa.repository.IUserRepository;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;


import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserJpaAdapter implements IUserPersistencePort {
    private final IUserRepository iUserRepository;
    private final IUserEntityMapper iUserEntityMapper;


    @Override
    public void save(User user) {
        try {
            iUserRepository.save(iUserEntityMapper.toUserEntity(user));
        } catch (DataAccessException | PersistenceException ex){
            throw new InfrastructureException(ConstantInfrastructure.USER_NOT_SAVED, ex);
        }
    }

    @Override
    public Optional<User> findById(Long idUser) {
        return Optional.ofNullable(iUserEntityMapper.toUser(
                iUserRepository.findById(idUser).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ConstantInfrastructure.USER_NOT_FOUND_IN_DB))
        ));
    }
}
