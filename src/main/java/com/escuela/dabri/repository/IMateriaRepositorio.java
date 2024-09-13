package com.escuela.dabri.repository;

import com.escuela.dabri.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepositorio extends JpaRepository<Materia,Integer> {
}
