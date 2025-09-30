package com.edsonsarmiento.cuentabancaria.controller;

import com.edsonsarmiento.cuentabancaria.dto.TipoCuentaDto;
import com.edsonsarmiento.cuentabancaria.service.TipoCuentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo-cuenta")
public class TipoCuentaController {

    @Autowired
    private TipoCuentaService tipoCuentaService;

    @Tag(name = "Tipo de cuenta")
    @Operation(description = "Mostrar todos los tipos de cuentas bancarias")
    @GetMapping()
    public ResponseEntity<?> mostrarTipoCuentas() {
        try{
            List<TipoCuentaDto> tipoCuentas = tipoCuentaService.listTipoCuentas();
            return new ResponseEntity<>(tipoCuentas,HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
