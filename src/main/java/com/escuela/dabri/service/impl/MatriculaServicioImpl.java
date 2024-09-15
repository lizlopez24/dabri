package com.escuela.dabri.service.impl;

import com.escuela.dabri.model.Matricula;
import com.escuela.dabri.repository.IMateriaRepositorio;
import com.escuela.dabri.repository.IMatriculaRepositorio;
import com.escuela.dabri.service.ICursoServicio;
import com.escuela.dabri.service.IMatriculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MatriculaServicioImpl implements IMatriculaServicio {
    @Autowired
    IMatriculaRepositorio matriculaRepositorio;
    @Override
    public List<Matricula> listarMatriculas() {
        return matriculaRepositorio.findAll();
    }

    @Override
    public Matricula crearMatricula(Matricula matricula) {
        matricula.setFecha(new Date());
        return matriculaRepositorio.save(matricula);
    }

    @Override
    public Matricula buscarMatricula(Integer idMatricula) {
        return matriculaRepositorio.findById(idMatricula).orElse(null);
    }

    @Override
    public void eliminarMatricula(Integer idMatricula) {
        matriculaRepositorio.deleteById(idMatricula);
    }
}
