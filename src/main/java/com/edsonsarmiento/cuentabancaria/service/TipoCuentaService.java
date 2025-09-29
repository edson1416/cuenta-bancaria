package com.edsonsarmiento.cuentabancaria.service;

import com.edsonsarmiento.cuentabancaria.dto.TipoCuentaDto;
import com.edsonsarmiento.cuentabancaria.repository.TipoCuentaRepository;
import com.edsonsarmiento.cuentabancaria.service.interfaces.TipoCuentaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoCuentaService implements TipoCuentaInterface {

    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;

    @Override
    public List<TipoCuentaDto> listTipoCuentas() {
        return List.of();
    }

    @Override
    public TipoCuentaDto findTipoCuenta(Long id) {
        return null;
    }

    @Override
    public TipoCuentaDto createTipoCuenta(TipoCuentaDto tipoCuenta) {
        return null;
    }

    @Override
    public TipoCuentaDto updateTipoCuenta(long id, TipoCuentaDto tipoCuenta) {
        return null;
    }

    @Override
    public void deleteTipoCuenta(long id) {

    }
}
