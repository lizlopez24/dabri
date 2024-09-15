package com.escuela.dabri.controller;

import com.escuela.dabri.model.Curso;
import com.escuela.dabri.service.IAulaServicio;
import com.escuela.dabri.service.ICursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursos")
public class CursoControlador {
    @Autowired
    private ICursoServicio cursoServicio;
    @Autowired
    private IAulaServicio aulaServicio;

    @GetMapping("")
    public String obtenerCursos(Model model){
        model.addAttribute("cursos",cursoServicio.cursos());
        return "cursos";
    }

    @GetMapping("/crear")
    public String crearCurso(Model model){
        model.addAttribute("curso", new Curso());
        model.addAttribute("aulas",aulaServicio.listarAulas());
        return "crearCurso";
    }

    @PostMapping("/guardar")
    public String guardarCurso(Curso curso){
        cursoServicio.crearCurso(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String editarCurso(@PathVariable Integer id, Model model){
        model.addAttribute("curso",cursoServicio.buscarCurso(id));
        model.addAttribute("aulas",aulaServicio.listarAulas());
        return "editarCurso";
    }
    @GetMapping("eliminar/{id}")
    public String eliminarCurso(@PathVariable Integer id){
        cursoServicio.eliminarCurso(id);
        System.out.println("Registo eliminado exitosamente ID:"+id);
        return "redirect:/cursos";
    }
}
