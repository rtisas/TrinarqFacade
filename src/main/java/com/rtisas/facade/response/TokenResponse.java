package com.rtisas.facade.response;

import com.rtisas.facade.entity.User;
import lombok.Data;

@Data
public class TokenResponse {
    private String token;
    private User user;
}
