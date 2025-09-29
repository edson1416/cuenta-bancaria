package com.edsonsarmiento.cuentabancaria.mapper;

import com.edsonsarmiento.cuentabancaria.dto.AperturaCuentaBancariaDto;
import com.edsonsarmiento.cuentabancaria.entity.Cliente;
import com.edsonsarmiento.cuentabancaria.entity.CuentaBancaria;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AperturaCuentaMapper {

    AperturaCuentaMapper INSTANCE = Mappers.getMapper(AperturaCuentaMapper.class);

    @Mappings({})
    Cliente aperturaDtoToCliente(AperturaCuentaBancariaDto  aperturaDto);

    @Mappings({})
    CuentaBancaria aperturaDtoToCuentaBancaria(AperturaCuentaBancariaDto aperturaDto);

}
