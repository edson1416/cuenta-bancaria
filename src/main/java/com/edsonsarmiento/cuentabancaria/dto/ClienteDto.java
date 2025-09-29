package com.edsonsarmiento.cuentabancaria.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private List<CuentaBancariaDto> cuentas;
}
