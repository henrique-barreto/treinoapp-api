package com.treinoapp.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable 
public class Perimetria {

	private BigDecimal ombro;
	private BigDecimal torax;
	private BigDecimal abdominal;
	private BigDecimal gluteo;
	private BigDecimal coxaSuperior;
	private BigDecimal coxaMedia;
	private BigDecimal coxaInferior;
	private BigDecimal bicepsContraido;
	private BigDecimal biceps;
	private BigDecimal antebraco;

	public BigDecimal getOmbro() {
		return ombro;
	}

	public void setOmbro(BigDecimal ombro) {
		this.ombro = ombro;
	}

	public BigDecimal getTorax() {
		return torax;
	}

	public void setTorax(BigDecimal torax) {
		this.torax = torax;
	}

	public BigDecimal getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(BigDecimal abdominal) {
		this.abdominal = abdominal;
	}

	public BigDecimal getGluteo() {
		return gluteo;
	}

	public void setGluteo(BigDecimal gluteo) {
		this.gluteo = gluteo;
	}

	public BigDecimal getCoxaSuperior() {
		return coxaSuperior;
	}

	public void setCoxaSuperior(BigDecimal coxaSuperior) {
		this.coxaSuperior = coxaSuperior;
	}

	public BigDecimal getCoxaMedia() {
		return coxaMedia;
	}

	public void setCoxaMedia(BigDecimal coxaMedia) {
		this.coxaMedia = coxaMedia;
	}

	public BigDecimal getCoxaInferior() {
		return coxaInferior;
	}

	public void setCoxaInferior(BigDecimal coxaInferior) {
		this.coxaInferior = coxaInferior;
	}

	public BigDecimal getBicepsContraido() {
		return bicepsContraido;
	}

	public void setBicepsContraido(BigDecimal bicepsContraido) {
		this.bicepsContraido = bicepsContraido;
	}

	public BigDecimal getBiceps() {
		return biceps;
	}

	public void setBiceps(BigDecimal biceps) {
		this.biceps = biceps;
	}

	public BigDecimal getAntebraco() {
		return antebraco;
	}

	public void setAntebraco(BigDecimal antebraco) {
		this.antebraco = antebraco;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n|================= Perimetria ========================");
		sb.append("\n|== ombro           : " + this.ombro);
		sb.append("\n|== torax           : " + this.torax);
		sb.append("\n|== abdominal       : " + this.abdominal);
		sb.append("\n|== glute           : " + this.gluteo);
		sb.append("\n|== coxaSuperior    : " + this.coxaSuperior);
		sb.append("\n|== coxaMedia       : " + this.coxaMedia);
		sb.append("\n|== coxaInferior    : " + this.coxaInferior);
		sb.append("\n|== bicepsContraido : " + this.bicepsContraido);
		sb.append("\n|== biceps          : " + this.biceps);
		sb.append("\n|== antebraco       : " + this.antebraco);
		sb.append("\n|=====================================================");
		return sb.toString();
	}

}
