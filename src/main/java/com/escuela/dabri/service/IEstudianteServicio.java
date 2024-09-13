package com.escuela.dabri.service;

import com.escuela.dabri.model.Estudiante;

import java.util.List;

public interface IEstudianteServicio {
    List<Estudiante> listarTodos();
    Estudiante crearEstudiante(Estudiante estudiante);

    Estudiante actualizarEstudiante(Integer idEstudiante, Estudiante estudiante);

    void eliminarEstudiante(Integer idEstudiante);
}
