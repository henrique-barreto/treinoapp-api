package com.treinoapp.avaliacao.dto;

import java.util.ArrayList;
import java.util.List;

public class GraficoDto {

	private List<String> dados = new ArrayList<String>();
	private List<String> labels = new ArrayList<String>();
	
	public List<String> getDados() {
		return dados;
	}
	public void setDados(List<String> dados) {
		this.dados = dados;
	}
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	
	

}
