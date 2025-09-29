package com.edsonsarmiento.cuentabancaria.dto;

import lombok.Data;

@Data
public class TipoCuentaDto {
    private Long id;

    private String nombreTipoCuenta;

    private String descripcionTipoCuenta;
}
