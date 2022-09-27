package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Signage {

    private Long id;
    private String nameSignage;
    private String descriptionSignage;
    private boolean statusSignage;
}
