package com.edsonsarmiento.cuentabancaria.service.interfaces;

import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.entity.Cliente;

import java.util.List;

public interface ClienteInterface {

    public List<ClienteDto> allClientes();
    public ClienteDto findClienteById(Long id);
    public ClienteDto createCliente(ClienteDto clienteDto);
    public ClienteDto updateCliente(Long id, ClienteDto clienteDto);
    public void deleteCliente(Long id);

}
