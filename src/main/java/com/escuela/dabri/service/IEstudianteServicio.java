package com.escuela.dabri.service;

import com.escuela.dabri.model.Estudiante;

import java.util.List;

public interface IEstudianteServicio {
    List<Estudiante> listarTodos();
    Estudiante crearEstudiante(Estudiante estudiante);

    Estudiante buscarEstudiante(Integer idEstudiante);

    void eliminarEstudiante(Integer idEstudiante);
}
