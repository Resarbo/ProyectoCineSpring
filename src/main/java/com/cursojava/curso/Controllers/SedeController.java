package com.cursojava.curso.Controllers;

import com.cursojava.curso.dao.SedeDao;
import com.cursojava.curso.models.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SedeController {

    @Autowired
    private SedeDao sedeDao;

    @GetMapping("/sedes")
    public String listarSedes(Model modelo){
        List<Sede> listaSedes = sedeDao.findAll();
        modelo.addAttribute("listaSedes", listaSedes);
        return "sedes";
    }

    @GetMapping("/sedes/nuevo")
    public String mostrarFormularioDeNuevoSede(Model modelo){
        modelo.addAttribute("sede", new Sede());
        return "sedes_formulario";
    }

    @PostMapping("/sedes/guardar")
    public String guardarSede(Sede sede){
        sedeDao.save(sede);
        return "redirect:/sedes";
    }
}
