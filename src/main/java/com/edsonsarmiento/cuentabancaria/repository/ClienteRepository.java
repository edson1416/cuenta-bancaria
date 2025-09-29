package com.edsonsarmiento.cuentabancaria.repository;

import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.entity.Cliente;
import feign.Param;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
