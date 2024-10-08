package com.escuela.dabri.service;

import com.escuela.dabri.model.Matricula;

import java.util.List;

public interface IMatriculaServicio {

    List<Matricula> listarMatriculas();
    Matricula crearMatricula(Matricula matricula);
    Matricula buscarMatricula(Integer idMatricula);
    void eliminarMatricula(Integer idMatricula);
}
