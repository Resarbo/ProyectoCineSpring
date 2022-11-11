package com.cursojava.curso.dao;


import com.cursojava.curso.models.Asientos;

import java.util.List;

public interface AsientosDao {

    void registrar(Asientos asientos);
    List<Asientos> getAsientosById(String id);

    List<Asientos> getAsientos();
}
