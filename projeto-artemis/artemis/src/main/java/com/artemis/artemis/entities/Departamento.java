package com.artemis.artemis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "tb_departamento")
public class Departamento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String sigla;
	private String urlSite;
	private String chefeDepartamento;
	
	public Departamento() {
	}
	
	public Departamento(Integer id, String nome, String telefone, String sigla, String urlSite,
			String chefeDepartamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.sigla = sigla;
		this.urlSite = urlSite;
		this.chefeDepartamento = chefeDepartamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getUrlSite() {
		return urlSite;
	}

	public void setUrlSite(String urlSite) {
		this.urlSite = urlSite;
	}

	public String getChefeDepartamento() {
		return chefeDepartamento;
	}

	public void setChefeDepartamento(String chefeDepartamento) {
		this.chefeDepartamento = chefeDepartamento;
	}
}
