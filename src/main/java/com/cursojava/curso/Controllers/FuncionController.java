package com.cursojava.curso.Controllers;

import com.cursojava.curso.dao.FuncionDao;
import com.cursojava.curso.dao.PeliculaDao;
import com.cursojava.curso.dao.SalaDao;
import com.cursojava.curso.dao.SedeDao;
import com.cursojava.curso.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FuncionController {
    @Autowired
    private FuncionDao funcionDao;

    @Autowired
    private PeliculaDao peliculaDao;

    @Autowired
    private SedeDao sedeDao;

    @Autowired
    private SalaDao salaDao;

    @GetMapping("funciones/nuevo")
    public String mostrarFormularioDeNuevoFuncion(Model modelo){
        modelo.addAttribute("funcion", new Funcion());
        List<Pelicula> listaPeliculas = peliculaDao.findAll();
        modelo.addAttribute("listaPeliculas", listaPeliculas);
        List<Sede> listaSedes = sedeDao.findAll();
        modelo.addAttribute("listaSedes", listaSedes);
        List<Sala> listaSalas = salaDao.findAll();
        modelo.addAttribute("listaSalas",listaSalas);
        return "funcion_formulario";
    }

    @PostMapping("/funciones/guardar")
    public String guardarFunciones(Funcion funcion){
        funcionDao.save(funcion);
        return "redirect:/";
    }

    @GetMapping("/funciones")
    public String listarFunciones(Model modelo){
        List<Funcion> listaFunciones = funcionDao.findAll();
        modelo.addAttribute("listaFunciones",listaFunciones);
        return "funciones";
    }

    @GetMapping("/funciones/editar/{id}")
    public String mostrarFormularioDeModificarFuncion(@PathVariable("id") Integer id, Model modelo){
        Funcion funcion = funcionDao.findById(id).get();
        modelo.addAttribute("funcion", funcion);

        List<Pelicula> listaPeliculas = peliculaDao.findAll();
        modelo.addAttribute("listaPeliculas", listaPeliculas);
        List<Sede> listaSedes = sedeDao.findAll();
        modelo.addAttribute("listaSedes", listaSedes);
        List<Sala> listaSala = salaDao.findAll();
        modelo.addAttribute("listaSala",listaSala);

        return "funcion_formulario";
    }

    @GetMapping("/funciones/eliminar/{id}")
    public String eliminarFuncion(@PathVariable("id") Integer id, Model modelo){
        funcionDao.deleteById(id);
        return "redirect:/funciones";
    }
}
