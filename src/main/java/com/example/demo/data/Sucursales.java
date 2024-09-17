package com.example.demo.data;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sucursales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sucursalId;
    private String nombre;

    @OneToMany(targetEntity = Ordenes.class, cascade = CascadeType.ALL)
    private List<Ordenes> ordenes;

    public long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(long sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ordenes> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Ordenes> ordenes) {
        this.ordenes = ordenes;
    }
}
