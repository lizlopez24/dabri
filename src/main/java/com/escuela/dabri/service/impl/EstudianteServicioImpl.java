package com.escuela.dabri.service.impl;

import com.escuela.dabri.model.Estudiante;
import com.escuela.dabri.repository.IDocenteRepositorio;
import com.escuela.dabri.repository.IEstudianteRepositorio;
import com.escuela.dabri.service.IEstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicioImpl implements IEstudianteServicio {
    @Autowired
    IEstudianteRepositorio estudianteRepositorio;
    @Override
    public List<Estudiante> listarTodos() {
        return estudianteRepositorio.findAll();
    }

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public Estudiante buscarEstudiante(Integer idEstudiante) {
        return estudianteRepositorio.findById(idEstudiante).orElse(null);
    }

    @Override
    public void eliminarEstudiante(Integer idEstudiante) {
    estudianteRepositorio.deleteById(idEstudiante);
    }
}
