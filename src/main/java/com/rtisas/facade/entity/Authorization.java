package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Authorization {

    private Long id;
    private Menu menu;
    private Role role;
    private boolean createAuth;
    private boolean readAuth;
    private boolean updateAuth;
    private boolean deleteAuth;
}
