package com.escuela.dabri.repository;

import com.escuela.dabri.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocenteRepositorio extends JpaRepository<Docente, Integer> {
}
