package com.escuela.dabri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControlador {
    @GetMapping("/index")
    public String index(){
        return "generico/genericoUI";
    }
}
