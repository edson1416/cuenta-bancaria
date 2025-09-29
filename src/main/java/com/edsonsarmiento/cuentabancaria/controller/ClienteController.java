package com.edsonsarmiento.cuentabancaria.controller;

import com.edsonsarmiento.cuentabancaria.dto.ClienteDto;
import com.edsonsarmiento.cuentabancaria.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @Tag(name = "Cliente", description = "Mantenimiento de tabla clientes")
    @GetMapping()
    public ResponseEntity<?> mostrarClientes(){
        try{
            List<ClienteDto> clientes = clienteService.allClientes();
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag(name = "Cliente")
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarClienteId(@PathVariable Long id){
        try{
            ClienteDto cliente = clienteService.findClienteById(id);
            return  new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch (RuntimeException ex){
            return  new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    /*@Tag(name = "Cliente")
    @PostMapping()
    public ResponseEntity<?> registrarCliente(@RequestBody ClienteDto clienteDto){
        try{
            ClienteDto cliente = clienteService.createCliente(clienteDto);
            return  new ResponseEntity<>(cliente, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }*/

    @Tag(name = "Cliente")
    @PutMapping("/{id}")
    public ResponseEntity<?> editarCliente(@RequestBody ClienteDto clienteDto, @PathVariable Long id){
        try {
            ClienteDto cliente = clienteService.updateCliente(id, clienteDto);
            return  new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @Tag(name = "Cliente")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id){
        try{
            clienteService.deleteCliente(id);
            return  new ResponseEntity<>("Cliente eliminado",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
