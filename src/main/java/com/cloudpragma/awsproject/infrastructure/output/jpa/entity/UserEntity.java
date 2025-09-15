    package com.cloudpragma.awsproject.infrastructure.output.jpa.entity;

    import com.cloudpragma.awsproject.domain.model.TypeDocumentEnum;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.time.LocalDate;

    @Entity
    @Table(name = "PRG_TBL_USERS")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "num_idUser")
        private Long id;

        @Column(name = "str_name")
        private String name;

        @Column(name = "str_last_name")
        private String lastName;

        @Enumerated(EnumType.STRING)
        @Column(name = "str_type_document")
        private TypeDocumentEnum typeDocument;

        @Column(name = "str_document")
        private String document;

        @Column(name = "str_phone_number")
        private String phoneNumber;

        @Column(name = "dtm_date_birth")
        private LocalDate dateBirth;

        @Column(name = "str_email")
        private String email;

        @Column(name = "stR_password")
        private String password;
    }
