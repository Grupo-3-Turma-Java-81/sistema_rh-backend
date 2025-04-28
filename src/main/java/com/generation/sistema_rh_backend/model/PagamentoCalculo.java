package com.generation.sistema_rh_backend.model;

import java.math.BigDecimal;

public class PagamentoCalculo {

	private String descricao;
	private BigDecimal salarioBaseHora;
	private String mesReferencia;
	private BigDecimal horasTotais;
	private BigDecimal bonus;
	private BigDecimal descontos;
	private BigDecimal valorFinal;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
