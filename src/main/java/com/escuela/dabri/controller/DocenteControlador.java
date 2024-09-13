package com.escuela.dabri.controller;

import com.escuela.dabri.model.Docente;
import com.escuela.dabri.repository.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/docentes")
public class DocenteControlador {
    @Autowired
    IDocenteRepositorio docenteRepositorio;

    @GetMapping("")
    public String listarDocentes(Model model){
        model.addAttribute("docentes",docenteRepositorio.findAll());
        return "docentes";
    }
    @GetMapping("/crear")
    public String crear(){
        return "crearDocente";
    }

    @PostMapping("/guardar")
    public String guardar(Docente docente){
        docenteRepositorio.save(docente);
        return "redirect:/docentes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Docente docente= docenteRepositorio.findById(id).orElse(null);
        model.addAttribute("docente",docente);
        return "editarDocente";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        Docente docente= docenteRepositorio.findById(id).orElse(null);
        docenteRepositorio.deleteById(id);
        return "redirect:/docentes";
    }



}
