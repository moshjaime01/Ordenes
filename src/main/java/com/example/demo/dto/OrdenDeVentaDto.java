package com.example.demo.dto;

import java.util.List;

public class OrdenDeVentaDto {

    private String sucursal;
    private List<ProductosDto> productosDtos;

    public List<ProductosDto> getProductosDtos() {
        return productosDtos;
    }

    public void setProductosDtos(List<ProductosDto> productosDtos) {
        this.productosDtos = productosDtos;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
}
