package com.artemis.artemis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String planoDeEnsino;
	
	public Disciplina(){
	}

	public Disciplina(Integer id, String name, String sigla, String descricao, Integer cargaHoraria, String planoDeEnsino) {
		this.id = id;
		this.name = name;
		this.sigla = sigla;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
		this.planoDeEnsino = planoDeEnsino;
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

	public String getPlanoDeEnsino() {
		return planoDeEnsino;
	}

	public void setPlanoDeEnsino(String planoDeEnsino) {
		this.planoDeEnsino = planoDeEnsino;
	}
}
