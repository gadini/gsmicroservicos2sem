package com.github.gadini.gs.gs.dtos;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SafraRequestCreateDto {
	private String nome;
	private BigDecimal tamanho;
	private Long temperatura;
	private LocalDate dataPlantio;
}
