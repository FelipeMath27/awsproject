package com.cloudpragma.awsproject.application.mapper;

import com.cloudpragma.awsproject.application.dto.UserDTOResponse;
import com.cloudpragma.awsproject.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {
    UserDTOResponse toUserDtoResponse(User user);

    User toUser(UserDTOResponse userDTOResponse);
}
