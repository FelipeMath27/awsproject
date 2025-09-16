package com.cloudpragma.awsproject.domain.usecase;


import com.cloudpragma.awsproject.domain.api.IUserServicePort;
import com.cloudpragma.awsproject.domain.exception.DomainException;
import com.cloudpragma.awsproject.domain.model.User;
import com.cloudpragma.awsproject.domain.spi.IUserPersistencePort;
import com.cloudpragma.awsproject.domain.utils.ConstantsErrorMessages;
import com.cloudpragma.awsproject.domain.validator.ValidatorCases;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UseCaseUser implements IUserServicePort {

    private final IUserPersistencePort iUserPersistencePort;

    @Override
    public void createUser(User user) {
        validateInfoUser(user);
        iUserPersistencePort.save(user);
    }

    private void validateInfoUser(User user) {
        user.setEmail(ValidatorCases.validateEmail(user.getEmail())
                .orElseThrow(() -> new DomainException(ConstantsErrorMessages.INVALID_EMAIL_FORMAT)));
        user.setPhoneNumber(ValidatorCases.validatePhoneNumber(user.getPhoneNumber())
                .orElseThrow(() -> new DomainException(ConstantsErrorMessages.INVALID_PHONE_NUMBER_FORMAT)));
        user.setName(ValidatorCases.sanitize(user.getName())
                .orElseThrow(() -> new DomainException(ConstantsErrorMessages.NAME_CANT_BE_NULL)));
        user.setLastName(ValidatorCases.sanitize(user.getLastName())
                .orElseThrow(() -> new DomainException(ConstantsErrorMessages.LAST_NAME_CANT_BE_NULL)));
        user.setDateBirth(user.getDateBirth());
        user.setDocument(user.getDocument());
        user.setTypeDocument(user.getTypeDocument());
        user.setPassword(user.getPassword());
    }

    @Override
    public User getUserById(Long idUser) {
        return iUserPersistencePort.findById(idUser)
                .orElseThrow(()-> new DomainException(ConstantsErrorMessages.USER_NOT_FOUD));
    }
}
