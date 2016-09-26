package com.treinoapp.avaliacao;

import java.math.BigDecimal;

public class ResultadoAvaliacao {

	private BigDecimal peso;
	private BigDecimal massaMagra;
	private BigDecimal massaGorda;
	private BigDecimal percentualGordura;

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getMassaMagra() {
		return massaMagra;
	}

	public void setMassaMagra(BigDecimal massaMagra) {
		this.massaMagra = massaMagra;
	}

	public BigDecimal getMassaGorda() {
		return massaGorda;
	}

	public void setMassaGorda(BigDecimal massaGorda) {
		this.massaGorda = massaGorda;
	}

	public BigDecimal getPercentualGordura() {
		return percentualGordura;
	}

	public void setPercentualGordura(BigDecimal percentualGordura) {
		this.percentualGordura = percentualGordura;
	}

}
