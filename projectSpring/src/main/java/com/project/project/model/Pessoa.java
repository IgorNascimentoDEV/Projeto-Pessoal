package com.project.project.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank
	@Column(length = 50, nullable = false)
	private String nome;
	
	@NotBlank
	@Column(length = 50, nullable = false)
	private String email;
	
	@NotBlank
	@Column(length = 15, nullable = false)
	private String numero;
}
