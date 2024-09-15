package com.escuela.dabri.service;

import com.escuela.dabri.model.Aula;

import java.util.List;

public interface IAulaServicio {

    List<Aula> listarAulas();
    Aula crearAula(Aula aula);
    Aula buscarAula(Integer id);
    void eliminarAula(Integer idAula);
}
