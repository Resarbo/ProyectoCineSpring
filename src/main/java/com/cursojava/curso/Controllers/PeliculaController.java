package com.cursojava.curso.Controllers;

import com.cursojava.curso.dao.ClasificacionDao;
import com.cursojava.curso.dao.GeneroDao;
import com.cursojava.curso.dao.PeliculaDao;
import com.cursojava.curso.models.Clasificacion;
import com.cursojava.curso.models.Genero;
import com.cursojava.curso.models.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PeliculaController {
    @Autowired
    private PeliculaDao peliculaDao;

    @Autowired
    private GeneroDao generoPeliculaDao;

    @Autowired
    private ClasificacionDao clasificacionDao;

    @GetMapping("peliculas/nuevo")
    public String mostrarFormularioDeNuevoPelicula(Model modelo){
        modelo.addAttribute("pelicula", new Pelicula());
        List<Clasificacion> listaClasificaciones = clasificacionDao.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);
        List<Genero> listaGeneros = generoPeliculaDao.findAll();
        modelo.addAttribute("listaGeneros",listaGeneros);
        return "pelicula_formulario";
    }

    @PostMapping("/peliculas/guardar")
    public String guardarPeliculas(Pelicula pelicula, HttpServletRequest request){
        String[] detallesIDs = request.getParameterValues("detalleID");
        String[] detallesSinopsis = request.getParameterValues("detallesSinopsis");
        String[] detallesDirectores = request.getParameterValues("detallesDirector");
        String[] detallesRepartos = request.getParameterValues("detallesReparto");

        for (int i = 0; i < detallesSinopsis.length; i++){
            if (detallesIDs != null && detallesIDs.length > 0){
                pelicula.setDetalle(Integer.valueOf(detallesIDs[i]),detallesSinopsis[i],detallesDirectores[i],detallesRepartos[i]);
            } else{
                pelicula.añadirDetalles(detallesSinopsis[i],detallesDirectores[i],detallesRepartos[i]);
            }
        }

        peliculaDao.save(pelicula);
        return "redirect:/";
    }

    @GetMapping("/peliculas")
    public String listarPeliculas(Model modelo){
        List<Pelicula> listaPeliculas = peliculaDao.findAll();
        modelo.addAttribute("listaPeliculas",listaPeliculas);
        return "peliculas";
    }

    @GetMapping("/peliculas/editar/{id}")
    public String mostrarFormularioDeModificarPelicula(@PathVariable("id") Integer id, Model modelo){
        Pelicula pelicula = peliculaDao.findById(id).get();
        modelo.addAttribute("pelicula", pelicula);

        List<Genero> listaGeneros = generoPeliculaDao.findAll();
        modelo.addAttribute("listaGeneros",listaGeneros);

        List<Clasificacion> listaClasificaciones = clasificacionDao.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);

        return "pelicula_formulario";
    }

    @GetMapping("/peliculas/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Integer id, Model modelo){
        peliculaDao.deleteById(id);
        return "redirect:/peliculas";
    }

    @GetMapping("/peliculas/detalles/{id}")
    public String detallesPelicula(@PathVariable("id") Integer id, Model modelo){
        Pelicula pelicula = peliculaDao.findById(id).get();
        modelo.addAttribute("pelicula", pelicula);

        List<Genero> listaGeneros = generoPeliculaDao.findAll();
        modelo.addAttribute("listaGeneros",listaGeneros);

        List<Clasificacion> listaClasificaciones = clasificacionDao.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);
        return "detalle";
    }

    @GetMapping("/peliculas/index")
    public String listarPeliculasEnIndex(Model modelo){
        List<Pelicula> listaPeliculas = peliculaDao.findAll();
        modelo.addAttribute("listaPeliculas",listaPeliculas);

        List<Genero> listaGeneros = generoPeliculaDao.findAll();
        modelo.addAttribute("listaGeneros",listaGeneros);

        List<Clasificacion> listaClasificaciones = clasificacionDao.findAll();
        modelo.addAttribute("listaClasificaciones", listaClasificaciones);
        return "cartelera";
    }
}
