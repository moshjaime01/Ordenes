package com.example.demo.data;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Ordenes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordenId;


    private Date fecha;
    private long total;

    @OneToMany(targetEntity = Productos.class, cascade = CascadeType.ALL)
    private List<Productos> productos;

    public long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(long ordenId) {
        this.ordenId = ordenId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }
}
