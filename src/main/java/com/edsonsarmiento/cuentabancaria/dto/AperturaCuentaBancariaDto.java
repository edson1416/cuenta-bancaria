package com.edsonsarmiento.cuentabancaria.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class AperturaCuentaBancariaDto {

    @NotNull(message = "El campo nombre no debe ser nulo")
    @Size(min=3, max=50)
    private String nombre;

    @NotNull(message = "El campo apellido no debe ser nulo")
    @Size(min=3, max=50)
    private String apellido;

    @NotNull(message = "el campo email no debe ser nulo")
    @Email(message = "formato no valido")
    private String email;

    private double capital;
    private String tipoCuenta;
    private Date fechaApertura;
    private Boolean activa ;
}
