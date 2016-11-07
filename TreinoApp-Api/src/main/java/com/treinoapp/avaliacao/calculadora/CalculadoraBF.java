package com.treinoapp.avaliacao.calculadora;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.treinoapp.avaliacao.model.AvaliacaoFisica;
import com.treinoapp.avaliacao.model.Dobras;
import com.treinoapp.usuario.model.Sexo;

public class CalculadoraBF {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private AvaliacaoFisica avaliacao;

	public CalculadoraBF(AvaliacaoFisica avaliacao) {
		this.avaliacao = avaliacao;
	}

	public ResultadoAvaliacao getResultado() {

		logger.debug("|---------- Gerando resultado avaliacao --------------------|");
		ResultadoAvaliacao resultado = new ResultadoAvaliacao();

		double massaGorda = calcMassaGorda();
		logger.debug("|-- Massa gorda: " + massaGorda);
		resultado.setMassaGorda(massaGorda);

		double massaMagra = calcMassaMagra();
		logger.debug("|-- Massa magra: " + massaMagra);
		resultado.setMassaMagra(massaMagra);

		double percentualGordura = calcPercentualGordura();
		logger.debug("|-- BF: " + percentualGordura);
		resultado.setPercentualGordura(percentualGordura);

		return resultado;
	}

	private double calcMassaMagra() {
		double peso = avaliacao.getAnamnese().getPeso();
		return peso - calcMassaGorda();
	}

	private double calcMassaGorda() {

		double peso = avaliacao.getAnamnese().getPeso();
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
		sumDobras += dobras.getAbdominal();
		sumDobras += dobras.getAxilarMedia();
		sumDobras += dobras.getFemuralMedio();
		sumDobras += dobras.getPeitoral();
		sumDobras += dobras.getSubescapular();
		sumDobras += dobras.getSuprailiaca();
		sumDobras += dobras.getTriceps();
		logger.debug("|-- Soma das 7 dobras: " + sumDobras);
		return sumDobras;
	}
}
