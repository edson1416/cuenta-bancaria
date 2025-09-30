package com.edsonsarmiento.cuentabancaria.service;

import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.entity.Cliente;
import com.edsonsarmiento.cuentabancaria.mapper.ClienteMapper;
import com.edsonsarmiento.cuentabancaria.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void testAllClientes(){
        //simulamos datos
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Edson");
        cliente.setApellido("Sarmiento");
        cliente.setEmail("edson@mail.com");

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(1L);
        clienteDto.setNombre("Edson");
        clienteDto.setApellido("Sarmiento");
        clienteDto.setEmail("edson@mail.com");

        //comportamiento
        when(clienteRepository.findAll()).thenReturn(
                List.of(cliente)
        );

        when(clienteMapper.toClienteDtoList(List.of(cliente))).thenReturn(
                List.of(clienteDto)
        );

        //llamada al metodo
        List<ClienteDto> resultado = clienteService.allClientes();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Edson", resultado.get(0).getNombre());

        verify(clienteRepository, times(1)).findAll();
        verify( clienteMapper, times(1)).toClienteDtoList(List.of(cliente));

    }
}
