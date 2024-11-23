package com.github.gadini.gs.gs.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Safra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(precision = 16, scale = 2)
	private BigDecimal tamanho;
	
	@Column(nullable = false)
	private Long temperatura;
	
	@Column(nullable = false)
	private LocalDate dataPlantio;
	
	
}
