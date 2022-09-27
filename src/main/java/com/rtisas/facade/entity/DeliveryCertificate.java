package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryCertificate {

    private Long id;
    private boolean approvedClientDeliveryCertificate;
    private boolean statusDeliveryCertificate;
    private StatusService statusServiceDeliveryCertificate;
    private Services serviceDeliveryCertificate;
}
