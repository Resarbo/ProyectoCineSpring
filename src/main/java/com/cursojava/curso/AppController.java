package com.cursojava.curso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String verPaginaDeInicioU(){
        return "indexUsuario.html";
    }

}
