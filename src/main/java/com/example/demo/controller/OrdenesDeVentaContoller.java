package com.example.demo.controller;

import com.example.demo.data.Ordenes;
import com.example.demo.data.Sucursales;
import com.example.demo.dto.OrdenDeVentaDto;
import com.example.demo.dto.ProductosDto;
import com.example.demo.service.OrdenesDeVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class OrdenesDeVentaContoller {

    @Autowired
    private OrdenesDeVentaService ordenesDeVentaService;

    @PostMapping(path = "/orden", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrdenDeVentaDto altaOrdenCompra(@RequestBody OrdenDeVentaDto ordenDeVentaDto){

        return ordenesDeVentaService.atlaOrden(ordenDeVentaDto);
    }

    @GetMapping(path = "/orden/{id}")
    public Sucursales getOrden(@PathVariable long id){
        return ordenesDeVentaService.getOrden(id);
    }

    @PutMapping(path = "/orden/{id}")
    public Sucursales putOrden(@PathVariable long id, @RequestBody ProductosDto productosDto){

        return ordenesDeVentaService.putOrden(id,productosDto);
    }



}
