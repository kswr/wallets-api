package com.kswr.wallets.api.walletsapi.model;


import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @Column
    private Geometry geo;

}
