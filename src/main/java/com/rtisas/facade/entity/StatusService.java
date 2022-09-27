package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class StatusService {

    private Long id;
    private String nameSSDC;

}
