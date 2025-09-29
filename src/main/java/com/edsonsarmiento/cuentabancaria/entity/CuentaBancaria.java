package com.edsonsarmiento.cuentabancaria.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroCuenta;

    private double capital;

    @Column()
    private String tipoCuenta;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaApertura;

    private Boolean activa = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonBackReference
    private Cliente cliente;

}
