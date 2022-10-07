package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FilesDC {

    private Long id;
    private DeliveryCertificate deliveryCertificate;
    private File file;
    private FiltersFilesDC filtersFilesDC;
    private String fileDescription;
}
