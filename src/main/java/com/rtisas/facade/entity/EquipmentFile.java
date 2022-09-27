package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EquipmentFile {

    private Long id;
    private Equipment equipment;
    private File files;
    private boolean statusEquipmentFile;
}
