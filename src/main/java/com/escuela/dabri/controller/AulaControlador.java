package com.escuela.dabri.controller;

import com.escuela.dabri.model.Aula;
import com.escuela.dabri.repository.IAulaRepositorio;
import com.escuela.dabri.service.IAulaServicio;
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
public class AulaControlador {

    @Autowired
    private IAulaServicio aulaServicio;

    @GetMapping("/aulas")
    public String listarAulas(Model model){
        model.addAttribute("aulas",aulaServicio.listarAulas());
        return "aulas";
    }
    @GetMapping("/crear-aula")
    public String crearAula(){
        return "crearAula";
    }

    @PostMapping("/guardar-aula")
    public String save(Aula aula){
        aulaServicio.crearAula(aula);
        return "redirect:/aulas";
    }

    @GetMapping("/editar-aula/{id}")
    public String editar(@PathVariable(value="id") int id, Model model){
        Aula aula= aulaServicio.buscarAula(id);
        model.addAttribute("a",aula);
        return "editarAula";
    }
    @PostMapping("/actualizar-aula")
    public String actualizar(Aula aula){
        aulaServicio.crearAula(aula);
        return "redirect:/aulas";
    }
    @GetMapping("/eliminar-aula/{id}")
    public String eliminar(@PathVariable Integer id){
        aulaServicio.eliminarAula(id);
        return "redirect:/aulas";
    }




}
