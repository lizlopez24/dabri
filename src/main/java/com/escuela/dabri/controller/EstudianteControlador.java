package com.escuela.dabri.controller;

import com.escuela.dabri.repository.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteControlador {
    @Autowired
    IEstudianteRepositorio estudianteRepositorio;

    @GetMapping("")
    public String obtenerEstudiantes(Model model){
        model.addAttribute("estudiantes",estudianteRepositorio.findAll());
        return "estudiantes";
    }

    @GetMapping("/crear")
    public String crearNuevo(){
        return "crearEstudiante";
    }
}
