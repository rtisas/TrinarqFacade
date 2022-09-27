package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Menu {

    private Long id;
    private String nameMenu;
    private String icon;
    private String path;
}
