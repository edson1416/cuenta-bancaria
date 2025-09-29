package com.edsonsarmiento.cuentabancaria.repository;

import com.edsonsarmiento.cuentabancaria.entity.TipoCuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Long> {
}
