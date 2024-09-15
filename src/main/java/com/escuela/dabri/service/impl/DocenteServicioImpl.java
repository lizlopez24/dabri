package com.escuela.dabri.service.impl;

import com.escuela.dabri.model.Docente;
import com.escuela.dabri.repository.IDocenteRepositorio;
import com.escuela.dabri.service.IDocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DocenteServicioImpl implements IDocenteServicio {
    @Autowired
    IDocenteRepositorio docenteRepositorio;

    @Override
    public List<Docente> listarDocentes() {
        return docenteRepositorio.findAll();
    }

    @Override
    public Docente crearDocente(Docente docente) {
        return docenteRepositorio.save(docente);
    }

    @Override
    public Docente buscarDocente(Integer id) {
        return docenteRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarDocente(Integer id) {
        docenteRepositorio.deleteById(id);
    }
}
