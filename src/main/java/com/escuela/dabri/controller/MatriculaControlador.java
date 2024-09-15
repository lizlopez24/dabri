package com.escuela.dabri.controller;

import com.escuela.dabri.model.Matricula;
import com.escuela.dabri.service.ICursoServicio;
import com.escuela.dabri.service.IEstudianteServicio;
import com.escuela.dabri.service.IMatriculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/matriculas")
public class MatriculaControlador {
    @Autowired
    IMatriculaServicio matriculaServicio;
    @Autowired
    IEstudianteServicio estudianteServicio;
    @Autowired
    ICursoServicio cursoServicio;

    @GetMapping("")
    public String listarMatriculas(Model model){
        model.addAttribute("matriculas",matriculaServicio.listarMatriculas());
        return "matriculas";
    }

    @GetMapping("/crear")
    public String crear(Model model){
        model.addAttribute("matricula", new Matricula());
        model.addAttribute("estudiantes", estudianteServicio.listarTodos());
        model.addAttribute("cursos", cursoServicio.cursos());
        return "crearMatricula";
    }

    @PostMapping("/guardar")
    public String guardar(Matricula matricula){
        matriculaServicio.crearMatricula(matricula);
        return "redirect:/matriculas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        model.addAttribute("matricula", matriculaServicio.buscarMatricula(id));
        model.addAttribute("estudiantes", estudianteServicio.listarTodos());
        model.addAttribute("cursos", cursoServicio.cursos());
        return "editarMatricula";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        matriculaServicio.eliminarMatricula(id);
        return "redirect:/matriculas";
    }
}
