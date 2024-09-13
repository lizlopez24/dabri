package com.escuela.dabri.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Curso implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private int nivel;
    private String paralelo;
    @OneToOne(targetEntity = Aula.class)
    @JoinColumn(name="idAula")
    private Aula aula;

    @OneToMany(targetEntity = Materia.class, fetch = FetchType.LAZY, mappedBy = "curso")
    private List<Materia> materias;

    @ManyToMany(targetEntity = Estudiante.class, fetch = FetchType.LAZY)
    @JoinTable(name = "matricula")
    private List<Estudiante> estudiantes;

}
