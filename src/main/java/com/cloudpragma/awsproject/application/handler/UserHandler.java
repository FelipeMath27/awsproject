package com.cloudpragma.awsproject.application.handler;

import com.cloudpragma.awsproject.application.dto.UserDTORequest;
import com.cloudpragma.awsproject.application.dto.UserDTOResponse;
import com.cloudpragma.awsproject.application.mapper.IUserRequestMapper;
import com.cloudpragma.awsproject.application.mapper.IUserResponseMapper;
import com.cloudpragma.awsproject.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserHandler implements IUserHandler{

    private final IUserServicePort iUserServicePort;
    private final IUserRequestMapper iUserRequestMapper;
    private final IUserResponseMapper iUserResponseMapper;

    @Override
    public void saveDTOUser(UserDTORequest userDTORequest) {
        iUserServicePort.createUser(iUserRequestMapper.toUser(userDTORequest));
    }

    @Override
    public UserDTOResponse getUserById(Long idUser) {
        return iUserResponseMapper.toUserDtoResponse(iUserServicePort.getUserById(idUser));
    }
}
