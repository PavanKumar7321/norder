package com.ensar.norder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity(name = "organization")
@Data
@EqualsAndHashCode(callSuper = true)
public class Organization extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "domain")
    private String domain;

    @Column(name = "disabled")
    private boolean disabled;

    

}
