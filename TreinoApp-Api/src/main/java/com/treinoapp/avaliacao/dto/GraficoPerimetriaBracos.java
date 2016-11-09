package com.treinoapp.avaliacao.dto;

import java.util.ArrayList;
import java.util.List;

public class GraficoPerimetriaBracos {

	private List<String> labels = new ArrayList<>();
	private List<String> dadosBicepsContraido = new ArrayList<>();
	private List<String> dadosBiceps = new ArrayList<>();
	private List<String> dadosAntebraco = new ArrayList<>();

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<String> getDadosBicepsContraido() {
		return dadosBicepsContraido;
	}

	public void setDadosBicepsContraido(List<String> dadosBicepsContraido) {
		this.dadosBicepsContraido = dadosBicepsContraido;
	}

	public List<String> getDadosBiceps() {
		return dadosBiceps;
	}

	public void setDadosBiceps(List<String> dadosBiceps) {
		this.dadosBiceps = dadosBiceps;
	}

	public List<String> getDadosAntebraco() {
		return dadosAntebraco;
	}

	public void setDadosAntebraco(List<String> dadosAntebraco) {
		this.dadosAntebraco = dadosAntebraco;
	}

}
