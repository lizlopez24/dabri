package com.escuela.dabri.repository;

import com.escuela.dabri.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatriculaRepositorio extends JpaRepository<Matricula,Integer> {
}
