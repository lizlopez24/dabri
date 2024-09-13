package com.escuela.dabri.repository;

import com.escuela.dabri.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepositorio extends JpaRepository<Curso,Integer> {
}
