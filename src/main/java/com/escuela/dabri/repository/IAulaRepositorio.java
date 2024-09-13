package com.escuela.dabri.repository;

import com.escuela.dabri.model.Aula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAulaRepositorio extends JpaRepository<Aula, Integer> {
}
