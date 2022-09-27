package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class BranchOffice {

    private Long id;
    private String nameBranchOffice;
    private String addressBranchOffice;
    private Customer customer;
    private City city;
}
