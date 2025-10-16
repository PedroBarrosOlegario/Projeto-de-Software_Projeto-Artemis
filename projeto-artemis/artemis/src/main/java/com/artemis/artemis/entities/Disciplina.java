package com.artemis.artemis.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_disciplina")
public class Disciplina {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String name;
	private String sigla;
	private String descricao;
	private Integer cargaHoraria;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	 
	@OneToOne(mappedBy = "disciplina", cascade = CascadeType.ALL)
	private PlanoDeEnsino planoDeEnsino;
	
	@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
	private List<Oferta> ofertas;

	public Disciplina(){
	}

	public Disciplina(Integer id, String name, String sigla, String descricao, Integer cargaHoraria) {
		this.id = id;
		this.name = name;
		this.sigla = sigla;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
     
    public PlanoDeEnsino getPlanoDeEnsino() {
        return planoDeEnsino;
      }

    public void setPlanoDeEnsino(PlanoDeEnsino planoDeEnsino) {
        this.planoDeEnsino = planoDeEnsino;
    }
}
