package com.cursojava.curso.models;

import javax.persistence.*;

@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    private int nroAsientos;

    @ManyToOne
    @JoinColumn(name = "sede_id")
    private Sede sede;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroAsientos() {
        return nroAsientos;
    }

    public void setNroAsientos(int nroAsientos) {
        this.nroAsientos = nroAsientos;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Sala() {
        super();
    }

    public Sala(Integer id, String nombre, int nroAsientos, Sede sede) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.nroAsientos = nroAsientos;
        this.sede = sede;
    }

    public Sala(String nombre, int nroAsientos, Sede sede) {
        super();
        this.nombre = nombre;
        this.nroAsientos = nroAsientos;
        this.sede = sede;
    }

    public Sala(Integer id) {
        super();
        this.id = id;
    }

    public Sala(String nombre) {
        super();
        this.nombre = nombre;
    }
}
