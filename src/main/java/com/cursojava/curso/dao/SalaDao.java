package com.cursojava.curso.dao;

import com.cursojava.curso.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaDao extends JpaRepository<Sala, Integer> {
}
