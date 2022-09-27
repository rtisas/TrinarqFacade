package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserLogin {
    private long id;
    private String username;
    private String password;
    private User userLogin;
    private List<Authorization> authorizationList;
}
