package com.edsonsarmiento.cuentabancaria.repository;

import com.edsonsarmiento.cuentabancaria.entity.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long> {
    boolean existsByNumeroCuentaAndIdNot(String numeroCuenta, Long id);
}
