package com.escuela.dabri.service.impl;

import com.escuela.dabri.model.Aula;
import com.escuela.dabri.repository.IAulaRepositorio;
import com.escuela.dabri.service.IAulaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServicioImpl implements IAulaServicio {

    @Autowired
    IAulaRepositorio aulaRepositorio;

    @Override
    public List<Aula> listarAulas(){
        return aulaRepositorio.findAll();
    }

    @Override
    public Aula crearAula(Aula aula){
        return aulaRepositorio.save(aula);
    }

    @Override
    public Aula buscarAula(Integer id){
        return aulaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarAula(Integer id){
        aulaRepositorio.deleteById(id);
    }
}
