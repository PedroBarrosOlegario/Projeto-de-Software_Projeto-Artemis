package com.artemis.artemis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_oferta")
public class Oferta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	public Oferta() {
		
	}

	public Oferta(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
