package com.artemis.artemis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_unidade")
public class Unidade {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer	id;
	private String nome;
	private String telefone;
	private String url;
	private String sigla;
	private String endereco;
	
	public Unidade() {
	}

	public Unidade(Integer id, String nome, String telefone, String url, String sigla, String endereco) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.url = url;
		this.sigla = sigla;
		this.endereco = endereco;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
