package com.escuela.dabri.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
public class Curso implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private int nivel;
    @OneToOne(targetEntity = Aula.class)
    @JoinColumn(name="idAula")
    private Aula aula;

    @OneToMany(targetEntity = Materia.class, fetch = FetchType.LAZY, mappedBy = "curso")
    private List<Materia> materias;

    @JsonBackReference
    @OneToMany(mappedBy = "curso")
    private List<Matricula> matriculas;

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nivel=" + nivel +
                ", aula=" + (aula != null ? aula.getIdAula() : "null") +
                '}';
    }
}
