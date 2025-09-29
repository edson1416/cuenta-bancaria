package com.edsonsarmiento.cuentabancaria.service.interfaces;

import com.edsonsarmiento.cuentabancaria.dto.TipoCuentaDto;

import java.util.List;

public interface TipoCuentaInterface {

    List<TipoCuentaDto> listTipoCuentas();
    TipoCuentaDto findTipoCuenta(Long id);
    TipoCuentaDto createTipoCuenta(TipoCuentaDto tipoCuenta);
    TipoCuentaDto updateTipoCuenta(long id,TipoCuentaDto tipoCuenta);
    void deleteTipoCuenta(long id);
}
