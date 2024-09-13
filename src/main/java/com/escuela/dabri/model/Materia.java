package com.escuela.dabri.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Materia implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;
    private String nombre;
    @OneToOne(targetEntity = Docente.class)
    @JoinColumn(name="idDocente")
    private Docente docenteAsignado;

    @ManyToOne(targetEntity = Curso.class)
    private Curso curso;
}
