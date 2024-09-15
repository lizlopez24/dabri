package com.escuela.dabri.controller;

import com.escuela.dabri.model.Materia;
import com.escuela.dabri.repository.IMateriaRepositorio;
import com.escuela.dabri.service.ICursoServicio;
import com.escuela.dabri.service.IDocenteServicio;
import com.escuela.dabri.service.IMateriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/materias")
public class MateriaControlador {
    @Autowired
    private IMateriaServicio materiaServicio;
    @Autowired
    private IDocenteServicio docenteServicio;
    @Autowired
    private ICursoServicio cursoServicio;

    @GetMapping("")
    public String obtenerMaterias(Model model){
        List<Materia> materias=materiaServicio.listarTodos();
        model.addAttribute("materias", materias);
        return "materias";
    }
    @GetMapping("/crear")
    public String crearMateria(Model model){
        model.addAttribute("materia",new Materia());
        model.addAttribute("docentes",docenteServicio.listarDocentes());
        model.addAttribute("cursos",cursoServicio.cursos());
        return "crearMateria";
    }
    @PostMapping("/guardar")
    public String guardarMateria(Materia materia){
        materiaServicio.crearMateria(materia);
        return "redirect:/materias";
    }

    @GetMapping("/editar/{id}")
    public String editarMateria(@PathVariable Integer id, Model model){
        model.addAttribute("materia",materiaServicio.buscarMateria(id));
        model.addAttribute("docentes",docenteServicio.listarDocentes());
        model.addAttribute("cursos",cursoServicio.cursos());
        return "editarMateria";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarMateria(@PathVariable Integer id){
        materiaServicio.eliminarMateria(id);
        return "redirect:/materias";
    }
}
