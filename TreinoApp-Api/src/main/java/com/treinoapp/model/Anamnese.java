package com.treinoapp.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Anamnese {

	private BigDecimal peso;
	private BigDecimal altura;
	private String objetivo;
	private int metaPeso;
	private int metaBF;

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public int getMetaPeso() {
		return metaPeso;
	}

	public void setMetaPeso(int metaPeso) {
		this.metaPeso = metaPeso;
	}

	public int getMetaBF() {
		return metaBF;
	}

	public void setMetaBF(int metaBF) {
		this.metaBF = metaBF;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n|=================== Anamnese ========================");
		sb.append("\n|== peso     : " + this.peso);
		sb.append("\n|== altura   : " + this.altura);
		sb.append("\n|== objetivo : " + this.objetivo);
		sb.append("\n|== metaPeso : " + this.metaPeso);
		sb.append("\n|== metaBF   : " + this.metaBF);
		sb.append("\n|=====================================================");
		return sb.toString();
	}

}
