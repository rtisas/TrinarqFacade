package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class City {

    private Long id;
    private String nameCity;
}
