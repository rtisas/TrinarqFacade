package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangePassword {

    private User user;
    private String newPassword;
}
