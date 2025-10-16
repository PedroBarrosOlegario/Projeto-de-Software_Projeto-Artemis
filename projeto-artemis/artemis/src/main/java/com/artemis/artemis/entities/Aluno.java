package com.artemis.artemis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer Id;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String email;
	private Integer matricula;
	private String genero;
	private String curso;
	private String carteiraIdentidade;
	private String nacionalidade;
	private String naturalidade;
	private String certificadoReservista;
	private String endereco;
	private String telefone;
	
	public Aluno() {
	}


	public Aluno(Integer id, String nome, String cpf, String dataNascimento, String email, Integer matricula,
			String genero, String curso, String carteiraIdentidade,String nacionalidade,String naturalidade, String certificadoReservista, String endereco, String telefone) {
		Id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.matricula = matricula;
		this.genero = genero;
		this.curso = curso;
		this.carteiraIdentidade = carteiraIdentidade;
		this.nacionalidade = nacionalidade;
		this.naturalidade = naturalidade;
		this.certificadoReservista = certificadoReservista;
		this.endereco = endereco;
		this.telefone = telefone;
		
	}
	
	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getMatricula() {
		return matricula;
	}


	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		curso = curso;
	}


	public String getCarteiraIdentidade() {
		return carteiraIdentidade;
	}


	public void setCarteiraIdentidade(String carteiraIdentidade) {
		this.carteiraIdentidade = carteiraIdentidade;
	}


	public String getNacionalidade() {
		return nacionalidade;
	}


	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	public String getNaturalidade() {
		return naturalidade;
	}


	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}


	public String getCertificadoReservista() {
		return certificadoReservista;
	}


	public void setCertificadoReservista(String certificadoRersevista) {
		this.certificadoReservista = certificadoReservista;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
}
