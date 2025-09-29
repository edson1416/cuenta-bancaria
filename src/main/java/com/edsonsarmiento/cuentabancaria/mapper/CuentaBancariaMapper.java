package com.edsonsarmiento.cuentabancaria.mapper;

import com.edsonsarmiento.cuentabancaria.dto.AperturaCuentaBancariaDto;
import com.edsonsarmiento.cuentabancaria.dto.CuentaBancariaDto;
import com.edsonsarmiento.cuentabancaria.entity.CuentaBancaria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaBancariaMapper {

    CuentaBancariaMapper INSTANCE = Mappers.getMapper(CuentaBancariaMapper.class);

    @Mappings({})
    CuentaBancariaDto toDto(CuentaBancaria cuenta);

    @InheritInverseConfiguration
    CuentaBancaria toEntity(CuentaBancariaDto cuentaDto);

    List<CuentaBancariaDto> toDtoList(List<CuentaBancaria> cuentas);

    List<CuentaBancaria> toEntityList(List<CuentaBancariaDto> cuentasDto);

}
