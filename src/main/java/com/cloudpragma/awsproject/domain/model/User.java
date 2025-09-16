package com.cloudpragma.awsproject.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long idUser;
	private String name;
	private String lastName;
    private TypeDocumentEnum typeDocument;
    private String document;
	private String phoneNumber;
	private LocalDate dateBirth;
	private String email;
    private String password;
}