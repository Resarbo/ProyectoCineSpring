package com.cursojava.curso.Controllers;

import com.cursojava.curso.dao.AsientosDao;
import com.cursojava.curso.models.Asientos;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.service.WordServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class WordController {

    @Autowired
    private WordServiceApi wordServiceApi;
    @Autowired
    private AsientosDao asientosDao;

    @RequestMapping(value = "api/crearboleto", method = RequestMethod.POST)
    public void run(@RequestBody Asientos asientos,Usuario usuario, String... args) throws Exception {
        asientos.setFecha(LocalDateTime.now());
        LocalDateTime now = asientos.getFecha();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String formatDateTime = now.format(formatter);
        asientos.setIdcliente("User"+formatDateTime);
        wordServiceApi.gaurdarInfoUsuario(asientos);



        wordServiceApi.createWord("Boleto de Compra","src/main/resources/static/Imagenes/EMPRESALOGO.png","ticket62.docx");
    }
}
