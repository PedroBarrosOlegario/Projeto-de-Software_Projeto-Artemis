package com.artemis.artemis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_universidade")
public class Universidade {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String telefone;
	private String cnpj;
	private String nome;
	private String sigla;
	private String endereco;
	private String url;
	private String Logo;
	
	public Universidade(){
	}

	public Universidade(String telefone, String cnpj, String nome, String sigla, String endereco, String url,
			String logo) {
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.nome = nome;
		this.sigla = sigla;
		this.endereco = endereco;
		this.url = url;
		Logo = logo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return Logo;
	}

	public void setLogo(String logo) {
		Logo = logo;
	}
}


