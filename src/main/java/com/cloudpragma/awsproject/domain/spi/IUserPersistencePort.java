package com.cloudpragma.awsproject.domain.spi;

import com.cloudpragma.awsproject.domain.model.User;

import java.util.Optional;

public interface IUserPersistencePort {
    void save(User user);
    Optional<User> findById(Long idUser);
}
