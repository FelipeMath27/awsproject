package com.cloudpragma.awsproject.infrastructure.output.jpa.mapper;

import com.cloudpragma.awsproject.domain.model.User;
import com.cloudpragma.awsproject.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);

}
