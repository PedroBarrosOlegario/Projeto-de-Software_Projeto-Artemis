package com.artemis.artemis.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idDisciplina;
    private Double nota;


    public Historico() {
    }

    public Historico(Integer id, Integer idDisciplina, Double nota) {
        this.id = id;
        this.idDisciplina = idDisciplina;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
