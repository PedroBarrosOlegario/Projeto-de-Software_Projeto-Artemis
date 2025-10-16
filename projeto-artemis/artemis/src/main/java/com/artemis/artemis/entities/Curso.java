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
import jakarta.persistence.Table;

@Entity
@Table( name= "tb_curso")
public class Curso {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private String sigla;
	private String descricao;
	private String coordenador;
	private String telefoneContato;
	private String urlSite;
	
	@ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Disciplina> disciplinas;
	
	public Curso() {
		
	}

	public Curso(Integer id, String nome, String sigla, String descricao, String coordenador, String telefoneContato,
			String urlSite) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.descricao = descricao;
		this.coordenador = coordenador;
		this.telefoneContato = telefoneContato;
		this.urlSite = urlSite;
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

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getUrlSite() {
		return urlSite;
	}

	public void setUrlSite(String urlSite) {
		this.urlSite = urlSite;
	}
	
	public Departamento getDepartamento() {
		return departamento; 
	}
    public void setDepartamento(Departamento departamento) {
    	this.departamento = departamento; 
    }
    
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
