package com.cursojava.curso.dao;


import com.cursojava.curso.models.Asientos;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AsientosDaoImp implements AsientosDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void registrar(Asientos asientos) {
        entityManager.merge(asientos);
    }

    @Override
    public List<Asientos> getAsientosById(String id) {
        return null;
    }

    @Override
    public List<Asientos> getAsientos() {
        String query = "FROM Asientos";
        return entityManager.createQuery(query).getResultList();
    }
}
