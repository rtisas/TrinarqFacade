package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class Equipment {

    private Long id;
    private String nameEquipment;
    private String serialNumberEquipment;
    private String modelNumberEquipment;
    private double heightEquipment;
    private String manufacturerEquipment;
    private String dimensions;
    private Boolean phaseEquipment;
    private String orientationEquipment;
    private double areaEquipment;
    private String capacityEquipment;
    private boolean statusEquipment;
    private User userId;
}