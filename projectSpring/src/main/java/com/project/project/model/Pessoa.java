package com.project.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="Contato")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	@Column(length = 50, nullable = false)
	private String nome;
	

	@Column(length = 50, nullable = false)
	private String email;
	

	@Column(length = 15, nullable = false)
	private String numero;
}
