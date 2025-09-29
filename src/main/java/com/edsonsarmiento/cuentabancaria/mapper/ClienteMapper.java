package com.edsonsarmiento.cuentabancaria.mapper;

import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CuentaBancariaMapper.class})
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mappings({
            @Mapping(target = "cuentas", source = "cuentas"),
    })
    ClienteDto ClienteToClienteDto(Cliente cliente);

    @InheritInverseConfiguration(name = "ClienteToClienteDto")
    Cliente ClienteDtoToCliente(ClienteDto clienteDto);

    List<ClienteDto> toClienteDtoList(List<Cliente> clientes);

}
