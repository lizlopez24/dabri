package com.escuela.dabri.service;

import com.escuela.dabri.model.Docente;

import javax.print.Doc;
import java.util.List;

public interface IDocenteServicio {
    List<Docente> listarDocentes();
    Docente crearDocente(Docente docente);
    Docente buscarDocente(Integer id);

    public void eliminarDocente(Integer id);

}
