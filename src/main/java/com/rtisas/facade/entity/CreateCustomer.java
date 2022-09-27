package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateCustomer {

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

    private String numberIdentificationCustomer;
    private String businessNameCustomer;
    private String emailCustomer;
    private boolean statusCustomer;
    private IdentificationType identificationTypeCustomer;

    private String nameBranchOffice;
    private String addressBranchOffice;
    private Customer customerBO;
    private City city;

    private String nameContact;
    private String emailContact;
    private String mobileContact;
    private String jobTitleContact;
    private Customer customerContact;
}
