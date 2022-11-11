package com.cursojava.curso.dao;

import com.cursojava.curso.models.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionDao extends JpaRepository<Funcion,Integer> {
}
