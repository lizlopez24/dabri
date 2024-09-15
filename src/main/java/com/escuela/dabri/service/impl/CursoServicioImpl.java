package com.escuela.dabri.service.impl;

import com.escuela.dabri.model.Curso;
import com.escuela.dabri.repository.ICursoRepositorio;
import com.escuela.dabri.service.ICursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CursoServicioImpl implements ICursoServicio {
    @Autowired
    ICursoRepositorio cursoRepositorio;
    @Override
    public Curso crearCurso(Curso curso) {
        return cursoRepositorio.save(curso);
    }

    @Override
    public List<Curso> cursos() {
        return cursoRepositorio.findAll();
    }

    @Override
    public Curso buscarCurso(Integer id) {
        return cursoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarCurso(Integer id) {
        cursoRepositorio.deleteById(id);
    }
}
