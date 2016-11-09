package com.treinoapp.avaliacao.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.treinoapp.avaliacao.model.AvaliacaoFisica;
import com.treinoapp.avaliacao.model.Perimetria;

public class EstatisticasDto {

	private List<AvaliacaoFisica> avaliacoes;
	private GraficoDto graficoBf = new GraficoDto();
	private GraficoDto graficoPeso = new GraficoDto();

	private GraficoPerimetriaInferior perimetriaInferiorDados = new GraficoPerimetriaInferior();
	private GraficoPerimetriaSuperior perimetriaSuperiorDados = new GraficoPerimetriaSuperior();
	private GraficoPerimetriaBracos perimetriaBracosDados = new GraficoPerimetriaBracos();

	public EstatisticasDto(List<AvaliacaoFisica> avaliacoes) {

		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("#0.00");

		this.avaliacoes = avaliacoes;

		for (AvaliacaoFisica a : avaliacoes) {

			double peso = a.getAnamnese().getPeso();
			double bf = a.getResultado().getPercentualGordura();

			graficoBf.getDados().add(df.format(bf));
			graficoBf.getLabels().add(a.getData());

			graficoPeso.getDados().add(df.format(peso));
			graficoPeso.getLabels().add(a.getData());

			Perimetria perimetria = a.getPerimetria();
			// inferior
			perimetriaInferiorDados.getLabels().add(a.getData());
			perimetriaInferiorDados.getDadosCoxaMedia().add(df.format(perimetria.getCoxaMedia()));
			perimetriaInferiorDados.getDadosCoxaInferior().add(df.format(perimetria.getCoxaInferior()));
			perimetriaInferiorDados.getDadosCoxaSuperior().add(df.format(perimetria.getCoxaSuperior()));
			perimetriaInferiorDados.getDadosGluteo().add(df.format(perimetria.getGluteo()));

			// superior
			perimetriaSuperiorDados.getLabels().add(a.getData());
			perimetriaSuperiorDados.getDadosAbdominal().add(df.format(perimetria.getAbdominal()));
			perimetriaSuperiorDados.getDadosTorax().add(df.format(perimetria.getTorax()));
			perimetriaSuperiorDados.getDadosOmbro().add(df.format(perimetria.getOmbro()));

			// bracos
			perimetriaBracosDados.getLabels().add(a.getData());
			perimetriaBracosDados.getDadosBiceps().add(df.format(perimetria.getBiceps()));
			perimetriaBracosDados.getDadosBicepsContraido().add(df.format(perimetria.getBicepsContraido()));
			perimetriaBracosDados.getDadosAntebraco().add(df.format(perimetria.getAntebraco()));

		}

	}

	public List<AvaliacaoFisica> getAvaliacoes() {
		return Collections.unmodifiableList(avaliacoes);
	}

	public GraficoDto getGraficoBf() {
		return graficoBf;
	}

	public GraficoDto getGraficoPeso() {
		return graficoPeso;
	}

	public GraficoPerimetriaInferior getPerimetriaInferiorDados() {
		return perimetriaInferiorDados;
	}

	public GraficoPerimetriaSuperior getPerimetriaSuperiorDados() {
		return perimetriaSuperiorDados;
	}

	public GraficoPerimetriaBracos getPerimetriaBracosDados() {
		return perimetriaBracosDados;
	}

}
