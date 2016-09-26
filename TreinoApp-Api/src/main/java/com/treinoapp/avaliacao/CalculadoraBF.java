package com.treinoapp.avaliacao;

import java.math.BigDecimal;

import com.treinoapp.model.AvaliacaoFisica;
import com.treinoapp.model.Dobras;
import com.treinoapp.model.Sexo;

public class CalculadoraBF {

	private AvaliacaoFisica avaliacao;

	public CalculadoraBF(AvaliacaoFisica avaliacao) {
		this.avaliacao = avaliacao;
	}

	public ResultadoAvaliacao getResultado() {

		ResultadoAvaliacao resultado = new ResultadoAvaliacao();

		BigDecimal massaGorda = new BigDecimal(calcMassaGorda());
		massaGorda.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		resultado.setMassaGorda(massaGorda);

		BigDecimal magra = new BigDecimal(calcMassaMagra());
		magra.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		resultado.setMassaMagra(magra);

		BigDecimal bf = new BigDecimal(calcPercentualGordura());
		bf.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		resultado.setPercentualGordura(bf);

		BigDecimal peso = avaliacao.getAnamnese().getPeso();
		peso.setScale(1, BigDecimal.ROUND_HALF_DOWN);
		resultado.setPeso(avaliacao.getAnamnese().getPeso());

		return resultado;

	}

	private double calcMassaMagra() {
		double peso = avaliacao.getAnamnese().getPeso().doubleValue();
		return peso - calcMassaGorda();
	}

	private double calcMassaGorda() {

		double peso = avaliacao.getAnamnese().getPeso().doubleValue();
		double bf = calcPercentualGordura();
		return (peso * bf) / 100;

	}

	private double calcPercentualGordura() {

		double dc = 0d;
		if (avaliacao.getAluno().getSexo() == Sexo.FEMININO) {
			dc = calcDensidadeCorporalMulher();
		} else {
			dc = calcDensidadeCorporalHomem();
		}

		double bf = ((4.95 / dc) - 4.50) * 100;
		return bf;
	}

	private double calcDensidadeCorporalMulher() {
		double densidade = 1.0970d - ((0.00046971 * soma7Dobras()) + (0.00000056 * (soma7Dobras() * soma7Dobras())))
				- (0.00012828 * (getIdade()));
		return densidade;
	}

	private double calcDensidadeCorporalHomem() {

		double densidade = 1.1120000d - ((0.00043499 * soma7Dobras()) + (0.00000055 * (soma7Dobras() * soma7Dobras())))
				- (0.0002882 * (getIdade()));

		return densidade;
	}

	private double getIdade() {
		return avaliacao.getAluno().getIdade();
	}

	private double soma7Dobras() {
		double sumDobras = 0;
		Dobras dobras = avaliacao.getDobras();
		sumDobras += dobras.getAbdominal().doubleValue();
		sumDobras += dobras.getAxilarMedia().doubleValue();
		sumDobras += dobras.getFemuralMedio().doubleValue();
		sumDobras += dobras.getPeitoral().doubleValue();
		sumDobras += dobras.getSubescapular().doubleValue();
		sumDobras += dobras.getSuprailiaca().doubleValue();
		sumDobras += dobras.getTriceps().doubleValue();
		return sumDobras;
	}
}
