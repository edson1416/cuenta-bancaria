package com.edsonsarmiento.cuentabancaria.service;

import com.edsonsarmiento.cuentabancaria.dto.AperturaCuentaBancariaDto;
import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.entity.Cliente;
import com.edsonsarmiento.cuentabancaria.entity.CuentaBancaria;
import com.edsonsarmiento.cuentabancaria.entity.TipoCuenta;
import com.edsonsarmiento.cuentabancaria.mapper.AperturaCuentaMapper;
import com.edsonsarmiento.cuentabancaria.mapper.ClienteMapper;
import com.edsonsarmiento.cuentabancaria.repository.ClienteRepository;
import com.edsonsarmiento.cuentabancaria.repository.CuentaBancariaRepository;
import com.edsonsarmiento.cuentabancaria.repository.TipoCuentaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CuentaBancariaTest {

    @Mock
    private TipoCuentaRepository tipoCuentaRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private CuentaBancariaRepository cuentaBancariaRepository;

    @Mock
    private AperturaCuentaMapper  aperturaCuentaMapper;

    @Mock
    private ClienteMapper  clienteMapper;

    @InjectMocks
    private CuentaBancariaService cuentaBancariaService;

    @Test
    void testAperturaCuentaBancaria() {

        AperturaCuentaBancariaDto dto = new AperturaCuentaBancariaDto();
        dto.setIdTipoCuenta(1L);
        dto.setNombre("Sarahi");
        dto.setApellido("Alejo");
        dto.setEmail("sary@mail.com");
        dto.setCapital(500.0);
        dto.setFechaApertura(new Date());
        dto.setActiva(true);

        //Datos simulados

        TipoCuenta tipoCuenta = new TipoCuenta();
        tipoCuenta.setId(1L);
        tipoCuenta.setNombreTipoCuenta("Ahorro");
        tipoCuenta.setDescripcionTipoCuenta("Cuenta de ahorro");

        Cliente cliente = new Cliente();
        cliente.setId(100L);
        cliente.setNombre("Sarahi");
        cliente.setApellido("Alejo");
        cliente.setEmail("sary@mail.com");

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setId(100L);
        nuevoCliente.setNombre("Sarahi");
        nuevoCliente.setApellido("Alejo");
        nuevoCliente.setEmail("sary@mail.com");

        CuentaBancaria cuenta = new CuentaBancaria();

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(100L);
        clienteDto.setNombre("Sarahi");
        clienteDto.setApellido("Alejo");
        clienteDto.setEmail("sary@mail.com");

        //que deberia responder
        when(tipoCuentaRepository.findById(1L)).thenReturn(Optional.of(tipoCuenta));
        when(aperturaCuentaMapper.aperturaDtoToCliente(dto)).thenReturn(cliente);
        when(clienteRepository.save(cliente)).thenReturn(nuevoCliente);
        when(aperturaCuentaMapper.aperturaDtoToCuentaBancaria(dto)).thenReturn(cuenta);
        when(clienteMapper.ClienteToClienteDto(cliente)).thenReturn(clienteDto);

        //Ejecución
        ClienteDto resultado = cuentaBancariaService.aperturaCuentaBancaria(dto);

        //validaciones
        assertNotNull(resultado);
        assertEquals(100L, resultado.getId());
        assertEquals("Sarahi", resultado.getNombre());

        //verificaciones
        verify(tipoCuentaRepository).findById(1L);
        verify(clienteRepository).save(cliente);
        verify(cuentaBancariaRepository).save(cuenta);
        verify(clienteMapper).ClienteToClienteDto(nuevoCliente);

        //chequear si el numero de cuenta se genero y asigno
        assertNotNull(cuenta.getNumeroCuenta());
        assertEquals(tipoCuenta, cuenta.getTipoCuenta());
        assertEquals(nuevoCliente, cuenta.getCliente());

    }
}
