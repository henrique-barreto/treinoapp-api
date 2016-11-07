package com.treinoapp.avaliacao.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Dobras {

	@Column(name = "DOBRA_SUBESCAPULAR")
	private double subescapular;
	@Column(name = "DOBRA_TRICEPS")
	private double triceps;
	@Column(name = "DOBRA_PEITORAL")
	private double peitoral;
	@Column(name = "DOBRA_AXILAR_MEDIA")
	private double axilarMedia;
	@Column(name = "DOBRA_SUPRAILIACA")
	private double suprailiaca;
	@Column(name = "DOBRA_ABDOMINALA")
	private double abdominal;
	@Column(name = "DOBRA_FEMURAL_MEDIO")
	private double femuralMedio;

	public double getSubescapular() {
		return subescapular;
	}

	public void setSubescapular(double subescapular) {
		this.subescapular = subescapular;
	}

	public double getTriceps() {
		return triceps;
	}

	public void setTriceps(double triceps) {
		this.triceps = triceps;
	}

	public double getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(double peitoral) {
		this.peitoral = peitoral;
	}

	public double getAxilarMedia() {
		return axilarMedia;
	}

	public void setAxilarMedia(double axilarMedia) {
		this.axilarMedia = axilarMedia;
	}

	public double getSuprailiaca() {
		return suprailiaca;
	}

	public void setSuprailiaca(double suprailiaca) {
		this.suprailiaca = suprailiaca;
	}

	public double getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(double abdominal) {
		this.abdominal = abdominal;
	}

	public double getFemuralMedio() {
		return femuralMedio;
	}

	public void setFemuralMedio(double femuralMedio) {
		this.femuralMedio = femuralMedio;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n|==================== Dobas ==========================");
		sb.append("\n|== subescapular : " + this.subescapular);
		sb.append("\n|== triceps      : " + this.triceps);
		sb.append("\n|== peitoral     : " + this.peitoral);
		sb.append("\n|== axilarMedia  : " + this.axilarMedia);
		sb.append("\n|== suprailiaca  : " + this.suprailiaca);
		sb.append("\n|== abdominal    : " + this.abdominal);
		sb.append("\n|== femuralMedio : " + this.femuralMedio);
		sb.append("\n|=====================================================");
		return sb.toString();
	}

}
