package com.escuela.dabri.service;

import com.escuela.dabri.model.Curso;

import java.util.List;

public interface ICursoServicio {
Curso crearCurso(Curso curso);
List<Curso> cursos();
Curso buscarCurso(Integer id);
public void eliminarCurso(Integer id);
}
