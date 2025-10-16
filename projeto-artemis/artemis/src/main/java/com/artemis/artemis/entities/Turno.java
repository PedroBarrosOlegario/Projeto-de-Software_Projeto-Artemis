package com.artemis.artemis.entities;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_turno")
public class Turno {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String nomeclatura;
	private String horarioInicio;
	private String horarioFim;
	
	@OneToMany(mappedBy = "turno", cascade = CascadeType.ALL)
	private List<Oferta> ofertas;
	
	public Turno() {
		
	}

	public Turno(Integer id, String nomeclatura, String horarioInicio, String horarioFim) {
		this.id = id;
		this.nomeclatura = nomeclatura;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeclatura() {
		return nomeclatura;
	}

	public void setNomeclatura(String nomeclatura) {
		this.nomeclatura = nomeclatura;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}	
}
