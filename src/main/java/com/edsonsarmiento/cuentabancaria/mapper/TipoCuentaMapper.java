package com.edsonsarmiento.cuentabancaria.mapper;

import com.edsonsarmiento.cuentabancaria.dto.TipoCuentaDto;
import com.edsonsarmiento.cuentabancaria.entity.TipoCuenta;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoCuentaMapper {
    TipoCuentaMapper INSTANCE = Mappers.getMapper(TipoCuentaMapper.class);

    @Mappings({})
    TipoCuenta dtoToEntity(TipoCuentaDto tipoCuentaDto);

    @InheritInverseConfiguration
    TipoCuentaDto entityToDto(TipoCuenta tipoCuenta);

    @Mappings({})
    List<TipoCuentaDto> listEntityToListDto(List<TipoCuenta> tipoCuentas);

}
