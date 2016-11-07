package com.treinoapp.avaliacao.dto;

public class CardGordura {

	private String percentualGordura;
	private String gorduraTotal;
	private String massaMagra;
	private String objetivo;
	private String[] data;

	public String getPercentualGordura() {
		return percentualGordura;
	}

	public void setPercentualGordura(String percentualGordura) {
		this.percentualGordura = percentualGordura;
	}

	public String getGorduraTotal() {
		return gorduraTotal;
	}

	public void setGorduraTotal(String gorduraTotal) {
		this.gorduraTotal = gorduraTotal;
	}

	public String getMassaMagra() {
		return massaMagra;
	}

	public void setMassaMagra(String massaMagra) {
		this.massaMagra = massaMagra;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

}
