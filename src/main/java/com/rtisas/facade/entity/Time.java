package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Time {

    private Long id;
    private String nameTimeSetting;
    private int valueTime;
}
