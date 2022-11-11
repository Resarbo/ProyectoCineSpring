package com.cursojava.curso.dao;

import com.cursojava.curso.models.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasificacionDao extends JpaRepository<Clasificacion, Integer> {
}
