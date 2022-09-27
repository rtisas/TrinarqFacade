package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class Contact {

    private Long id;
    private String nameContact;
    private String emailContact;
    private String mobileContact;
    private String jobTitleContact;
    private boolean statusContact;
    private Customer customerContact;
}
