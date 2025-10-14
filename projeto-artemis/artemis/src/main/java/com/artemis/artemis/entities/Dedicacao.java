package com.artemis.artemis.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_dedicacao")
public class Dedicacao {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	public Dedicacao() {
		
	}

	public Dedicacao(Integer id) {

		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
