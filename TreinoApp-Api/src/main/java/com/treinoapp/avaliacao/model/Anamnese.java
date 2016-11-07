package com.treinoapp.avaliacao.model;

import javax.persistence.Embeddable;

@Embeddable
public class Anamnese {

	private double peso;
	private int altura;
	private String objetivo;
	private double metaPeso;
	private int metaBF;

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public double getMetaPeso() {
		return metaPeso;
	}

	public void setMetaPeso(double metaPeso) {
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
