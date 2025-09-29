package com.edsonsarmiento.cuentabancaria.service;

import com.edsonsarmiento.cuentabancaria.dto.AperturaCuentaBancariaDto;
import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.dto.CuentaBancariaDto;
import com.edsonsarmiento.cuentabancaria.entity.Cliente;
import com.edsonsarmiento.cuentabancaria.entity.CuentaBancaria;
import com.edsonsarmiento.cuentabancaria.entity.TipoCuenta;
import com.edsonsarmiento.cuentabancaria.mapper.AperturaCuentaMapper;
import com.edsonsarmiento.cuentabancaria.mapper.ClienteMapper;
import com.edsonsarmiento.cuentabancaria.mapper.CuentaBancariaMapper;
import com.edsonsarmiento.cuentabancaria.repository.ClienteRepository;
import com.edsonsarmiento.cuentabancaria.repository.CuentaBancariaRepository;
import com.edsonsarmiento.cuentabancaria.repository.TipoCuentaRepository;
import com.edsonsarmiento.cuentabancaria.service.interfaces.CuentaBancariaInterface;
import com.edsonsarmiento.cuentabancaria.util.NumeroCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaService implements CuentaBancariaInterface {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaBancariaRepository cuentaBancariaRepository;

    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;

    @Autowired
    private AperturaCuentaMapper  aperturaCuentaMapper;

    @Autowired
    private ClienteMapper  clienteMapper;
    @Autowired
    private CuentaBancariaMapper cuentaBancariaMapper;




    @Override
    public ClienteDto aperturaCuentaBancaria(AperturaCuentaBancariaDto data) {

        TipoCuenta tipoCuenta = tipoCuentaRepository.findById(data.getIdTipoCuenta()).orElseThrow(()-> new RuntimeException("Tipo de cuenta no encontrado"));
        Cliente cliente = aperturaCuentaMapper.aperturaDtoToCliente(data);
        Cliente nuevoCliente = clienteRepository.save(cliente);

        CuentaBancaria cuenta = aperturaCuentaMapper.aperturaDtoToCuentaBancaria(data);

        NumeroCuenta obj = new NumeroCuenta();
        String numeroCuenta = obj.generarNumeroCuenta();
        cuenta.setNumeroCuenta(numeroCuenta);
        cuenta.setTipoCuenta(tipoCuenta);
        cuenta.setCliente(nuevoCliente);

        cuentaBancariaRepository.save(cuenta);

        return clienteMapper.ClienteToClienteDto(nuevoCliente);
    }

    @Override
    public void eliminarCuentaBancaria(Long cuentaBancariaId) {
        if (!cuentaBancariaRepository.existsById(cuentaBancariaId)) {
            throw new RuntimeException("La cuenta bancaria no existe");
        }
        cuentaBancariaRepository.deleteById(cuentaBancariaId);
    }

    @Override
    public CuentaBancariaDto editarCuentaBancaria(Long id, CuentaBancariaDto data) {
        CuentaBancaria cuenta = cuentaBancariaRepository.findById(id).orElseThrow(()->new RuntimeException("Cuenta bancaria no encontrada"));

        if (cuentaBancariaRepository.existsByNumeroCuentaAndIdNot(data.getNumeroCuenta(), cuenta.getId())) {
            throw new RuntimeException("Este numero de cuenta ya existente");
        }else {
            TipoCuenta tipoCuenta = tipoCuentaRepository.findById(data.getTipoCuenta().getId()).orElseThrow(()-> new RuntimeException("Tipo de cuenta no encontrado"));
            cuenta.setNumeroCuenta(data.getNumeroCuenta());
            cuenta.setTipoCuenta(tipoCuenta);
            cuenta.setActiva(data.getActiva());
            cuentaBancariaRepository.save(cuenta);

            return cuentaBancariaMapper.toDto(cuenta);
        }
    }

}
