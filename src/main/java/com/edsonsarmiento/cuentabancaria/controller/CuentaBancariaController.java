package com.edsonsarmiento.cuentabancaria.controller;

import com.edsonsarmiento.cuentabancaria.dto.AperturaCuentaBancariaDto;
import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.dto.CuentaBancariaDto;
import com.edsonsarmiento.cuentabancaria.service.CuentaBancariaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta-bancaria")
public class CuentaBancariaController {

    @Autowired
    CuentaBancariaService cuentaBancariaService;

    @Tag(name = "Cuenta bancaria")
    @Operation(summary = "Apertura de cuenta bancaria",description = "Apertura de nueva cuenta bancaria y registro de nuevo usuario")
    @PostMapping()
    public ResponseEntity<?> aperturaCuentaBancaria(@Valid @RequestBody AperturaCuentaBancariaDto aperturaDto) {
        cuentaBancariaService.aperturaCuentaBancaria(aperturaDto);
        return new ResponseEntity<>("Apertura de nueva cuenta exitosa.", HttpStatus.OK);
    }

    @Tag(name = "Cuenta bancaria")
    @Operation(summary = "Actualizar cuenta bancaria", description = "Actualizar datos generales de cuenta bancaria")
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCuentaBancaria(@PathVariable Long id, @RequestBody CuentaBancariaDto cuentaDto) {
        try{
            CuentaBancariaDto cuenta = cuentaBancariaService.editarCuentaBancaria(id, cuentaDto);
            return new ResponseEntity<>(cuenta, HttpStatus.OK);
        }catch(RuntimeException ex){
            return new  ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @Tag(name = "Cuenta bancaria")
    @Operation(summary = "Eliminar cuenta bancaria", description = "Eliminar cuenta bancaria de manera definitiva")
    @DeleteMapping()
    public ResponseEntity<?> eliminarCuentaBancaria(@RequestParam Long id){
        try{
            cuentaBancariaService.eliminarCuentaBancaria(id);
            return new ResponseEntity<>("Cuenta eliminada exitosa.", HttpStatus.OK);
        }catch(RuntimeException ex) {
            return new  ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
