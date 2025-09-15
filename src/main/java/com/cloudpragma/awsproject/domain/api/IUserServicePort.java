package com.cloudpragma.awsproject.domain.api;

import com.cloudpragma.awsproject.domain.model.User;

public interface IUserServicePort {
    void createUser(User user);
    User getUserById(Long idUser);
}
