package com.edsonsarmiento.cuentabancaria.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CuentaBancariaDto {

    private Long id;

    private String numeroCuenta;

    private double capital;

    private String tipoCuenta;

    private Date fechaApertura;

    private Boolean activa ;

}
