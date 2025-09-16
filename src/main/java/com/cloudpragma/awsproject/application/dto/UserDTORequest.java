package com.cloudpragma.awsproject.application.dto;

import com.cloudpragma.awsproject.domain.model.TypeDocumentEnum;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTORequest {
    private String name;
    private String lastName;
    private TypeDocumentEnum typeDocument;
    private String document;
    private String phoneNumber;
    private LocalDate dateBirth;
    private String email;
    private String password;
}


