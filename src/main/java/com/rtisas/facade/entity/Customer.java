package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {

    private Long id;
    private String numberIdentification;
    private String businessNameCustomer;
    private String emailCustomer;
    private boolean statusCustomer;
    private IdentificationType identificationType;

}
