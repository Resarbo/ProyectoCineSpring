package com.cursojava.curso.Controllers;

import com.cursojava.curso.dao.AsientosDao;
import com.cursojava.curso.models.Asientos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class AsientoController {
    @Autowired
    private AsientosDao asientosDao;

    @RequestMapping(value = "api/guardarInfo",method = RequestMethod.POST)
    public void agregarUsuario(@RequestBody Asientos asientos) {
        asientos.setFecha(LocalDateTime.now());
        LocalDateTime now = asientos.getFecha();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String formatDateTime = now.format(formatter);
        asientos.setIdcliente("User"+formatDateTime+asientos.getCosto());
        asientosDao.registrar(asientos);
    }
    @RequestMapping(value = "api/asientos", method = RequestMethod.GET)
    public List<Asientos> obtenerUsuarios(){
        return asientosDao.getAsientos();
    }

    @RequestMapping(value = "susuario")
    public Asientos agregarUsuarios(Asientos asientos) {

        asientos.setFecha(LocalDateTime.now());

        return asientos;
    }
}
