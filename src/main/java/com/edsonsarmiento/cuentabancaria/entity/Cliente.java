package com.edsonsarmiento.cuentabancaria.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<CuentaBancaria> cuentas = new ArrayList<>();

}
