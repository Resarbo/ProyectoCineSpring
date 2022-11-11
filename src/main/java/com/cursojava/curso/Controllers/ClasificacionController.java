package com.cursojava.curso.Controllers;

import com.cursojava.curso.dao.ClasificacionDao;
import com.cursojava.curso.models.Clasificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClasificacionController {
    @Autowired
    private ClasificacionDao clasificacionDao;

    @GetMapping("/clasificacion")
    public String listarClasificaciones(Model modelo){
        List<Clasificacion> listaClasificaciones = clasificacionDao.findAll();
        modelo.addAttribute("listaClasificaciones",listaClasificaciones);
        return "clasificacion";
    }

    @GetMapping("/clasificacion/nuevo")
    public String mostrarFormularioDeNuevaClasificacion(Model modelo){
        modelo.addAttribute("clasificacion", new Clasificacion());
        return "clasificacion_formulario";
    }

    @PostMapping("/clasificacion/guardar")
    public String guardarClasificacion(Clasificacion clasificacion){
        clasificacionDao.save(clasificacion);
        return "redirect:/clasificacion";
    }
}
