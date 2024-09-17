package com.example.demo.service;

import com.example.demo.data.Ordenes;
import com.example.demo.data.Productos;
import com.example.demo.data.Sucursales;
import com.example.demo.dto.OrdenDeVentaDto;
import com.example.demo.dto.ProductosDto;
import com.example.demo.repository.SucursalesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrdenesDeVentaService {

    final private SucursalesRepository sucursalesRepository;

    public OrdenesDeVentaService(SucursalesRepository sucursalesRepository) {
        this.sucursalesRepository = sucursalesRepository;
    }

    public OrdenDeVentaDto atlaOrden(OrdenDeVentaDto ordenDeVentaDto){

        Sucursales sucursales = new Sucursales();
        sucursales.setNombre(ordenDeVentaDto.getSucursal());

        Ordenes ordenes = new Ordenes();
        ordenes.setFecha(new Date());
        List<Productos> productosList = new ArrayList<>();
        long total = 0;

        for(ProductosDto productosDto: ordenDeVentaDto.getProductosDtos()){

            Productos productos = new Productos();
            productos.setCodigo(productosDto.getCodigo());
            productos.setDescripcion(productosDto.getDescripcion());
            productos.setPrecio(productosDto.getPrecio());
            productosList.add(productos);
            total = total + productosDto.getPrecio();

        }

        ordenes.setProductos(productosList);
        List<Ordenes> ordenes1 = new ArrayList<>();
        ordenes1.add(ordenes);
        sucursales.setOrdenes(ordenes1);
        sucursalesRepository.save(sucursales);

        return ordenDeVentaDto;

    }

    public Sucursales getOrden(long id){

        return sucursalesRepository.findById(id).get();

    }

    public Sucursales putOrden(long id,ProductosDto productosDto){
        Sucursales sucursales = sucursalesRepository.findById(id).get();
        for(Productos produc: sucursales.getOrdenes().get(0).getProductos()){
            if(produc.getCodigo().equals(productosDto.getCodigo())){
                produc.setPrecio(productosDto.getPrecio());
            }
        }
        sucursalesRepository.save(sucursales);
        return sucursales;
    }
}
