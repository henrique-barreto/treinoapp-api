package com.treinoapp.avaliacao.model;

import javax.persistence.Embeddable;

@Embeddable
public class Perimetria {

	private double ombro;
	private double torax;
	private double abdominal;
	private double gluteo;
	private double coxaSuperior;
	private double coxaMedia;
	private double coxaInferior;
	private double bicepsContraido;
	private double biceps;
	private double antebraco;

	public double getOmbro() {
		return ombro;
	}

	public void setOmbro(double ombro) {
		this.ombro = ombro;
	}

	public double getTorax() {
		return torax;
	}

	public void setTorax(double torax) {
		this.torax = torax;
	}

	public double getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(double abdominal) {
		this.abdominal = abdominal;
	}

	public double getGluteo() {
		return gluteo;
	}

	public void setGluteo(double gluteo) {
		this.gluteo = gluteo;
	}

	public double getCoxaSuperior() {
		return coxaSuperior;
	}

	public void setCoxaSuperior(double coxaSuperior) {
		this.coxaSuperior = coxaSuperior;
	}

	public double getCoxaMedia() {
		return coxaMedia;
	}

	public void setCoxaMedia(double coxaMedia) {
		this.coxaMedia = coxaMedia;
	}

	public double getCoxaInferior() {
		return coxaInferior;
	}

	public void setCoxaInferior(double coxaInferior) {
		this.coxaInferior = coxaInferior;
	}

	public double getBicepsContraido() {
		return bicepsContraido;
	}

	public void setBicepsContraido(double bicepsContraido) {
		this.bicepsContraido = bicepsContraido;
	}

	public double getBiceps() {
		return biceps;
	}

	public void setBiceps(double biceps) {
		this.biceps = biceps;
	}

	public double getAntebraco() {
		return antebraco;
	}

	public void setAntebraco(double antebraco) {
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
