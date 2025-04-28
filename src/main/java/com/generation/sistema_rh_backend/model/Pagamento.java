package com.generation.sistema_rh_backend.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_pagamentos")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private BigDecimal salarioBaseHora;

	@NotBlank
	@Size(min = 5, max = 10)
	private String mesReferencia;

	@NotNull
	private BigDecimal horasTotais;

	@NotNull
	private BigDecimal bonus;

	@NotNull
	private BigDecimal descontos;

	@NotNull
	private BigDecimal valorFinal;

	@ManyToOne
	@JsonIgnoreProperties("pagamento")
	private Funcionario funcionario;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSalarioBaseHora() {
		return salarioBaseHora;
	}

	public void setSalarioBaseHora(BigDecimal salarioBaseHora) {
		this.salarioBaseHora = salarioBaseHora;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public BigDecimal getHorasTotais() {
		return horasTotais;
	}

	public void setHorasTotais(BigDecimal horasTotais) {
		this.horasTotais = horasTotais;
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public BigDecimal getDescontos() {
		return descontos;
	}

	public void setDescontos(BigDecimal descontos) {
		this.descontos = descontos;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

}
