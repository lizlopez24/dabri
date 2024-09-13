package com.escuela.dabri.controller;

import com.escuela.dabri.model.Aula;
import com.escuela.dabri.repository.IAulaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/aulas")
public class AulaControlador {

    @Autowired
    private IAulaRepositorio aulaRepositorio;

    @GetMapping("")
    public String listarAulas(Model model){
        model.addAttribute("aulas",aulaRepositorio.findAll());
        return "aulas";
    }
    @GetMapping("/crear")
    public String crearAula(){
        return "crearAula";
    }
    @PostMapping("/guardar")
    public String save(Aula aula){
        aulaRepositorio.save(aula);
        return "redirect:/aulas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Aula aula= aulaRepositorio.findById(id).orElse(null);
        model.addAttribute("a",aula);
        return "editarAula";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        aulaRepositorio.deleteById(id);
        return "redirect:/aulas";
    }




}
