package com.cloudpragma.awsproject.application.handler;

import com.cloudpragma.awsproject.application.dto.UserDTORequest;
import com.cloudpragma.awsproject.application.dto.UserDTOResponse;

public interface IUserHandler{
    void saveDTOUser(UserDTORequest userDTORequest);
    UserDTOResponse getUserById(Long idUser);
}
