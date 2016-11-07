package com.treinoapp.avaliacao.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.treinoapp.avaliacao.model.AvaliacaoFisica;

public class EstatisticasDto {

	public EstatisticasDto(List<AvaliacaoFisica> avaliacoes) {
		this.avaliacoes = avaliacoes;

		List<Double> listaBF = new ArrayList<>();
		List<Double> listaPeso = new ArrayList<>();
		for (AvaliacaoFisica a : avaliacoes) {
			double peso = a.getAnamnese().getPeso();
			listaPeso.add(peso);
			double bf = a.getResultado().getPercentualGordura();
			listaBF.add(bf);
		}

		this.setDadosBF(pegarArrayString(listaBF));
		this.setDadosPeso(pegarArrayString(listaPeso));

	}

	private String[] pegarArrayString(List<Double> medidas) {

		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("#0.00");

		List<String> medidasStr = new ArrayList<String>();
		for (Double d : medidas) {
			medidasStr.add(df.format(d));
		}

		String[] array = new String[medidasStr.size()];
		return medidasStr.toArray(array);
	}

	private List<AvaliacaoFisica> avaliacoes;

	private String[] dadosBF;
	private String[] dadosPeso;

	public String[] getDadosBF() {
		return dadosBF;
	}

	private void setDadosBF(String[] dadosBF) {
		this.dadosBF = dadosBF;
	}

	public String[] getDadosPeso() {
		return dadosPeso;
	}

	private void setDadosPeso(String[] dadosPeso) {
		this.dadosPeso = dadosPeso;
	}

	public List<AvaliacaoFisica> getAvaliacoes() {
		return Collections.unmodifiableList(avaliacoes);
	}

}
