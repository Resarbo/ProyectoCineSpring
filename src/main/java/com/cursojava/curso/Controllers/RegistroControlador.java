package com.cursojava.curso.Controllers;

import com.cursojava.curso.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroControlador {
    @Autowired
    private UsuarioServicio servicio;

    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }

    @GetMapping("/admin")
    public String verPaginaDeInicio() {
        return "indexAdmin.html";
    }
}
