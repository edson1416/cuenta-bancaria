package com.edsonsarmiento.cuentabancaria.util;

import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class NumeroCuenta {

    public String generarNumeroCuenta() {
       // return ThreadLocalRandom.current().nextInt(10_000_000, 100_000_000);
        String uuid = UUID.randomUUID().toString().replaceAll("[^0-9]", "");
        return uuid.substring(0, Math.min(uuid.length(), 12));
    }
}
