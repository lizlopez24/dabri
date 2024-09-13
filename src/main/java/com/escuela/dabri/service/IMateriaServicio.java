package com.escuela.dabri.service;

import com.escuela.dabri.model.Materia;

import java.util.List;

public interface IMateriaServicio {
    List<Materia> listarTodos();
    Materia crearMateria(Materia materia);
    Materia actualizarMateria(Integer idMateria, Materia materia);
     void eliminarMateria(Integer idMateria);
}
