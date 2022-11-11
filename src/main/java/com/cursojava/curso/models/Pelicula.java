package com.cursojava.curso.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    private String duracion;

    private String link;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero generoPelicula;

    @ManyToOne
    @JoinColumn(name = "clasificacion_id")
    private Clasificacion clasificacion;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    private List<PeliculaDetalles> detalles = new ArrayList<>();

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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Genero getGeneroPelicula() {
        return generoPelicula;
    }

    public void setGeneroPelicula(Genero generoPelicula) {
        this.generoPelicula = generoPelicula;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public List<PeliculaDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<PeliculaDetalles> detalles) {
        this.detalles = detalles;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDetalle(Integer id, String sinopsis, String director, String reparto) {
        this.detalles.add(new PeliculaDetalles(id,sinopsis,director,reparto,this));
    }

    public Pelicula(Integer id, String nombre, String duracion, Genero generoPelicula, Clasificacion clasificacion, String link) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.generoPelicula = generoPelicula;
        this.clasificacion = clasificacion;
        this.link = link;
    }

    public Pelicula() {
        super();
    }

    public Pelicula(Integer id) {
        super();
        this.id = id;
    }

    public Pelicula(String nombre, String duracion) {
        super();
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Pelicula(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Pelicula(String nombre, String duracion, Genero generoPelicula, Clasificacion clasificacion, String link) {
        super();
        this.nombre = nombre;
        this.duracion = duracion;
        this.generoPelicula = generoPelicula;
        this.clasificacion = clasificacion;
        this.link = link;
    }
    public void añadirDetalles(String sinopsis, String director, String reparto){
        this.detalles.add(new PeliculaDetalles(sinopsis,director,reparto,this));
    }
}
