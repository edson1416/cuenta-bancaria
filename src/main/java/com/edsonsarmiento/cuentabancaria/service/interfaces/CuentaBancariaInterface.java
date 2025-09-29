package com.edsonsarmiento.cuentabancaria.service.interfaces;

import com.edsonsarmiento.cuentabancaria.dto.AperturaCuentaBancariaDto;
import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.dto.CuentaBancariaDto;

public interface CuentaBancariaInterface {
     public ClienteDto aperturaCuentaBancaria(AperturaCuentaBancariaDto data);
     public void eliminarCuentaBancaria(Long cuentaBancariaId);
     public CuentaBancariaDto editarCuentaBancaria(Long id,CuentaBancariaDto data);
}
