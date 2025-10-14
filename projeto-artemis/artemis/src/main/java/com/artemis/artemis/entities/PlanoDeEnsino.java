package com.artemis.artemis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_planoDeEnsino")
public class PlanoDeEnsino {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String ementa;
	private String objetivo;
	private String conteudo;
	private String referencias;
	
	
	public PlanoDeEnsino() {
		
	}

	public PlanoDeEnsino(Integer id, String ementa, String objetivo, String conteudo, String referencias) {
		this.id = id;
		this.ementa = ementa;
		this.objetivo = objetivo;
		this.conteudo = conteudo;
		this.referencias = referencias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getReferencias() {
		return referencias;
	}

	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}
}
