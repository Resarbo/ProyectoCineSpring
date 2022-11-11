package com.cursojava.curso.dao;

import com.cursojava.curso.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaDao extends JpaRepository<Pelicula, Integer> {
}
