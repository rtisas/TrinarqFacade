package com.rtisas.facade.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Data
@NoArgsConstructor
public class Services {

    private Long id;

    @Column(name = "created_date_service")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-CO", timezone = "America/Bogota")
    private Date createdDateService;
    @Column(name = "scheduled_date_service")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "es-CO", timezone = "America/Bogota")
    private String scheduled_date_service;
    @Column(name = "completed_date_service")
    private Date completed_date_service;
    @Column(name = "delivery_address_service")
    private String deliveryAddressService;
    @Column(name = "purchase_order")
    private String purchaseOrder;
    @Column(name = "description_service")
    private String descriptionService;
    @OneToOne
    @JoinColumn(name = "status_service")
    private StatusService statusService;
    @OneToOne
    @JoinColumn(name = "primary_customer_service")
    private Customer primaryCustomer;
    @OneToOne
    @JoinColumn(name = "secondary_customer_service")
    private Customer secondaryCustomer;
    @OneToOne
    @JoinColumn(name = "type_service")
    private TypeService typeService;
    @OneToOne
    @JoinColumn(name = "crew_leader_service")
    private Employee crewLeader;
    private Employee projectCoordinator;

}
