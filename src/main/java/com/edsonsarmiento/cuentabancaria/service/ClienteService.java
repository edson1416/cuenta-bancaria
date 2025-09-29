package com.edsonsarmiento.cuentabancaria.service;

import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.entity.Cliente;
import com.edsonsarmiento.cuentabancaria.mapper.ClienteMapper;
import com.edsonsarmiento.cuentabancaria.repository.ClienteRepository;
import com.edsonsarmiento.cuentabancaria.service.interfaces.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClienteService implements ClienteInterface {

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDto> allClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toClienteDtoList(clientes);
    }

    @Override
    public ClienteDto findClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return clienteMapper.ClienteToClienteDto(cliente);
    }

    @Override
    public ClienteDto createCliente(ClienteDto clienteDto) {
        System.out.println(clienteDto);
        Cliente cliente = clienteRepository.save(clienteMapper.ClienteDtoToCliente(clienteDto));
        return clienteMapper.ClienteToClienteDto(cliente);
    }

    @Override
    public ClienteDto updateCliente(Long id, ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setEmail(clienteDto.getEmail());

        return clienteMapper.ClienteToClienteDto(clienteRepository.save(cliente));
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
