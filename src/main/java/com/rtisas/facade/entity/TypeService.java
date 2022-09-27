package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class TypeService {

    private Long id;
    private String nameTypeService;
    private String descriptionTypeService;
    private boolean statusTypeService;

}
