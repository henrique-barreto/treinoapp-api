package com.treinoapp.avaliacao.dto;

import java.util.ArrayList;
import java.util.List;

public class GraficoPerimetriaSuperior {

	private List<String> labels = new ArrayList<>();
	private List<String> dadosOmbro = new ArrayList<>();
	private List<String> dadosTorax = new ArrayList<>();
	private List<String> dadosAbdominal = new ArrayList<>();

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<String> getDadosOmbro() {
		return dadosOmbro;
	}

	public void setDadosOmbro(List<String> dadosOmbro) {
		this.dadosOmbro = dadosOmbro;
	}

	public List<String> getDadosTorax() {
		return dadosTorax;
	}

	public void setDadosTorax(List<String> dadosTorax) {
		this.dadosTorax = dadosTorax;
	}

	public List<String> getDadosAbdominal() {
		return dadosAbdominal;
	}

	public void setDadosAbdominal(List<String> dadosAbdominal) {
		this.dadosAbdominal = dadosAbdominal;
	}

}
