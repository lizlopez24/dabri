package com.escuela.dabri.controller;

import com.escuela.dabri.model.Estudiante;
import com.escuela.dabri.repository.IEstudianteRepositorio;
import com.escuela.dabri.service.IEstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteControlador {
    @Autowired
    IEstudianteServicio estudianteServicio;

    @GetMapping("")
    public String obtenerEstudiantes(Model model){
        model.addAttribute("estudiantes",estudianteServicio.listarTodos());
        return "estudiantes";
    }

    @GetMapping("/crear")
    public String crearNuevo(){
        return "crearEstudiante";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(Estudiante estudiante){
        estudianteServicio.crearEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable Integer id, Model model){
        Estudiante estudiante=estudianteServicio.buscarEstudiante(id);
        model.addAttribute("estudiante",estudiante);
        return "editarEstudiante";
    }

    @GetMapping("eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Integer id){
        estudianteServicio.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
