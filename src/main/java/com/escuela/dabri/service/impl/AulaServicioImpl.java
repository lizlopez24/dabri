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
    public Aula actualizarAula(Integer id, Aula aula){
        Aula aulaBd= aulaRepositorio.findById(id).orElse(null);
        if(aulaBd!=null){
            aulaBd.setNumero(aula.getNumero());
            aulaBd.setCapacidad(aula.getCapacidad());
            return aulaRepositorio.save(aulaBd);
        }
        return null;
    }

    @Override
    public void eliminarAula(Integer id){
        aulaRepositorio.deleteById(id);
    }
}
