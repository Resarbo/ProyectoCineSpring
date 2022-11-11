package com.cursojava.curso.dao;

import com.cursojava.curso.models.Sede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SedeDao extends JpaRepository<Sede,Integer> {
}
