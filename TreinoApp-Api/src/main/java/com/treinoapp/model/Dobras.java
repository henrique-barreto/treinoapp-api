package com.treinoapp.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Dobras {

	@Column(name = "DOBRA_SUBESCAPULAR")
	private BigDecimal subescapular;
	@Column(name = "DOBRA_TRICEPS")
	private BigDecimal triceps;
	@Column(name = "DOBRA_PEITORAL")
	private BigDecimal peitoral;
	@Column(name = "DOBRA_AXILAR_MEDIA")
	private BigDecimal axilarMedia;
	@Column(name = "DOBRA_SUPRAILIACA")
	private BigDecimal suprailiaca;
	@Column(name = "DOBRA_ABDOMINALA")
	private BigDecimal abdominal;
	@Column(name = "DOBRA_FEMURAL_MEDIO")
	private BigDecimal femuralMedio;

	public BigDecimal getSubescapular() {
		return subescapular;
	}

	public void setSubescapular(BigDecimal subescapular) {
		this.subescapular = subescapular;
	}

	public BigDecimal getTriceps() {
		return triceps;
	}

	public void setTriceps(BigDecimal triceps) {
		this.triceps = triceps;
	}

	public BigDecimal getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(BigDecimal peitoral) {
		this.peitoral = peitoral;
	}

	public BigDecimal getAxilarMedia() {
		return axilarMedia;
	}

	public void setAxilarMedia(BigDecimal axilarMedia) {
		this.axilarMedia = axilarMedia;
	}

	public BigDecimal getSuprailiaca() {
		return suprailiaca;
	}

	public void setSuprailiaca(BigDecimal suprailiaca) {
		this.suprailiaca = suprailiaca;
	}

	public BigDecimal getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(BigDecimal abdominal) {
		this.abdominal = abdominal;
	}

	public BigDecimal getFemuralMedio() {
		return femuralMedio;
	}

	public void setFemuralMedio(BigDecimal femuralMedio) {
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
