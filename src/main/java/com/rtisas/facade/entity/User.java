package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private Long id;
    private IdentificationType identificationType;
    private String numberIdentification;
    private String nameUser;
    private String lastNameUser;
    private String phoneNumberUser;
    private String emailUser;
    private Role role;
    private Customer customer;
    private boolean statusUser;
    private File pictureUser;

}
