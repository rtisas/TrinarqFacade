package com.rtisas.facade.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignageDelivCert {

    private Long id;
    private DeliveryCertificate deliveryCertificate;
    private Signage signage;
    private int count;
    private boolean statusSDC;
}
