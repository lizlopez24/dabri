package com.escuela.dabri.service.impl;

import com.escuela.dabri.model.Materia;
import com.escuela.dabri.repository.IMateriaRepositorio;
import com.escuela.dabri.service.IMateriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaServicioImpl implements IMateriaServicio {
    @Autowired
    IMateriaRepositorio materiaRepositorio;
    @Override
    public List<Materia> listarTodos() {
        return materiaRepositorio.findAll();
    }

    @Override
    public Materia crearMateria(Materia materia) {
        return materiaRepositorio.save(materia);
    }

    @Override
    public Materia buscarMateria(Integer idMateria) {
        return materiaRepositorio.findById(idMateria).orElse(null);
    }

    @Override
    public void eliminarMateria(Integer idMateria) {
        materiaRepositorio.deleteById(idMateria);
    }
}
