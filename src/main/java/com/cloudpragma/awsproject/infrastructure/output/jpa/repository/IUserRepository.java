package com.cloudpragma.awsproject.infrastructure.output.jpa.repository;

import com.cloudpragma.awsproject.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Long> {
}
