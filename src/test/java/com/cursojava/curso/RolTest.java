package com.cursojava.curso;

import com.cursojava.curso.models.Rol;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RolTest {
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCrearRoles(){
        Rol rolAdmin = new Rol("Administrador");
        Rol rolUsuario = new Rol("Usuario");

        entityManager.persist(rolAdmin);
        entityManager.persist(rolUsuario);
    }
}
