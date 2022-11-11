package com.cursojava.curso.Controllers;

import com.cursojava.curso.dao.GeneroDao;
import com.cursojava.curso.models.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GeneroController {
    @Autowired
    private GeneroDao generoPeliculaDao;

    @GetMapping("/generos")
    public String listarCategorias(Model modelo){
        List<Genero> listaGeneros = generoPeliculaDao.findAll();
        modelo.addAttribute("listaGeneros",listaGeneros);
        return "generos";
    }

    @GetMapping("/generos/nuevo")
    public String mostrarFormularioDeNuevaGenero(Model modelo){
        modelo.addAttribute("genero", new Genero());
        return "genero_formulario";
    }

    @PostMapping("/generos/guardar")
    public String guardarGenero(Genero generoPelicula){
        generoPeliculaDao.save(generoPelicula);
        return "redirect:/generos";
    }
}
