package com.cursojava.curso.Controllers;

import com.cursojava.curso.dao.SalaDao;
import com.cursojava.curso.dao.SedeDao;
import com.cursojava.curso.models.Sala;
import com.cursojava.curso.models.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SalaController {
    @Autowired
    private SalaDao salaDao;

    @Autowired
    private SedeDao sedeDao;

    @GetMapping("salas/nueva")
    public String mostrarFormularioDeNuevoSala(Model modelo){
        List<Sede> listaSedes = sedeDao.findAll();
        modelo.addAttribute("sala", new Sala());
        modelo.addAttribute("listaSedes", listaSedes);
        return "salas_formulario";
    }

    @PostMapping("salas/guardar")
    public String guardarSala(Sala sala){
        salaDao.save(sala);
        return "redirect:/";
    }

    @GetMapping("/salas")
    public String listarSalas(Model modelo){
        List<Sala> listaSalas = salaDao.findAll();
        modelo.addAttribute("listaSalas",listaSalas);
        return "salas";
    }

    @GetMapping("/salas/editar/{id}")
    public String mostrarFormularioDeModificarSalas(@PathVariable("id") Integer id, Model modelo){
        Sala sala = salaDao.findById(id).get();
        modelo.addAttribute("sala", sala);

        List<Sede> listaSedes = sedeDao.findAll();
        modelo.addAttribute("listaSedes", listaSedes);

        return "salas_formulario";
    }

    @GetMapping("/salas/eliminar/{id}")
    public String eliminarSala(@PathVariable("id") Integer id, Model modelo){
        salaDao.deleteById(id);
        return "redirect:/salas";
    }
}
