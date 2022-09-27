package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Role {

    private Long id;
    private String nameRole;
    private String descriptionRole;
}
