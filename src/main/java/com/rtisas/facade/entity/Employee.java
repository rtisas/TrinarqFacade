package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
    private Long id;
    private User user;
    private JobTitle jobTitleEmployee;
    private String rhEmployee;
    private Eps eps;
}
