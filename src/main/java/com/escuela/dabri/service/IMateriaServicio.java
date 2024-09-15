package com.escuela.dabri.service;

import com.escuela.dabri.model.Materia;

import java.util.List;

public interface IMateriaServicio {
    List<Materia> listarTodos();
    Materia crearMateria(Materia materia);
    Materia buscarMateria(Integer idMateria);
     void eliminarMateria(Integer idMateria);
}
