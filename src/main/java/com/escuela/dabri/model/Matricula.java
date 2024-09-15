package com.escuela.dabri.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Matricula implements Serializable {
    public static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatricula;
    private Date fecha;

    @ManyToOne(targetEntity = Estudiante.class)
    @JoinColumn(name="idEstudiante")
    private Estudiante estudiante;

    @ManyToOne (targetEntity = Curso.class)
    @JsonBackReference
    @JoinColumn(name="idCurso")
    private Curso curso;

    @PrePersist
    protected void onCreate() {
        this.fecha = new Date();
    }
}
