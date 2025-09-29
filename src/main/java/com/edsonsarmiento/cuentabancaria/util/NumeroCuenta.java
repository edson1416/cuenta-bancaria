package com.edsonsarmiento.cuentabancaria.util;

import org.springframework.context.annotation.Bean;

import java.util.concurrent.ThreadLocalRandom;

public class NumeroCuenta {

    public Integer generarNumeroCuenta() {
        return ThreadLocalRandom.current().nextInt(10_000_000, 10_000_000);
    }
}
