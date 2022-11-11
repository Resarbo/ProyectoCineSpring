package com.cursojava.curso.dao;

import com.cursojava.curso.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroDao extends JpaRepository<Genero, Integer> {
}
