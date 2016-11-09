package com.treinoapp.avaliacao.dto;

import java.util.ArrayList;
import java.util.List;

public class GraficoPerimetriaInferior {

	private List<String> labels = new ArrayList<>();
	private List<String> dadosGluteo = new ArrayList<>();
	private List<String> dadosCoxaInferior = new ArrayList<>();
	private List<String> dadosCoxaMedia = new ArrayList<>();
	private List<String> dadosCoxaSuperior = new ArrayList<>();

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<String> getDadosGluteo() {
		return dadosGluteo;
	}

	public void setDadosGluteo(List<String> dadosGluteo) {
		this.dadosGluteo = dadosGluteo;
	}

	public List<String> getDadosCoxaInferior() {
		return dadosCoxaInferior;
	}

	public void setDadosCoxaInferior(List<String> dadosCoxaInferior) {
		this.dadosCoxaInferior = dadosCoxaInferior;
	}

	public List<String> getDadosCoxaMedia() {
		return dadosCoxaMedia;
	}

	public void setDadosCoxaMedia(List<String> dadosCoxaMedia) {
		this.dadosCoxaMedia = dadosCoxaMedia;
	}

	public List<String> getDadosCoxaSuperior() {
		return dadosCoxaSuperior;
	}

	public void setDadosCoxaSuperior(List<String> dadosCoxaSuperior) {
		this.dadosCoxaSuperior = dadosCoxaSuperior;
	}

}
