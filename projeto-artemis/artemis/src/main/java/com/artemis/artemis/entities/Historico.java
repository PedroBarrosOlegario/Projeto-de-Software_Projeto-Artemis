package com.artemis.artemis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_historico" )
public class Historico {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String disciplinasCursadas;
	private Integer ano;
	
	public Historico() {
		
	}

	public Historico(Integer id, String disciplinasCursadas, Integer ano) {
		this.id = id;
		this.disciplinasCursadas = disciplinasCursadas;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisciplinasCursadas() {
		return disciplinasCursadas;
	}

	public void setDisciplinasCursadas(String disciplinasCursadas) {
		this.disciplinasCursadas = disciplinasCursadas;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
