package com.treinoapp.avaliacao.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.avaliacao.calculadora.ResultadoAvaliacao;
import com.treinoapp.avaliacao.dao.AvaliacaoRepository;
import com.treinoapp.avaliacao.dto.CardGordura;
import com.treinoapp.avaliacao.dto.CardPeso;
import com.treinoapp.avaliacao.dto.ResultadoDto;
import com.treinoapp.avaliacao.model.AvaliacaoFisica;
import com.treinoapp.infra.exceptions.DefaultError;
import com.treinoapp.infra.exceptions.MyEntityNotFoundException;

@Service
@Transactional
public class AvaliacaoResultadoService {

	@Autowired
	private AvaliacaoRepository repository;

	private NumberFormat fmt = new DecimalFormat("#0.00");
	private NumberFormat fmt1dec = new DecimalFormat("#0.0");

	public ResultadoDto pegarResultado(Long id) {

		AvaliacaoFisica avaliacao = repository.findOne(id);
		if (avaliacao == null) {
			throw new MyEntityNotFoundException(new DefaultError("123", "Avaliacao com id " + id + " nao encontrada."));
		}
		ResultadoAvaliacao resultado = avaliacao.getResultado();
		CardGordura cardGordura = montarCardGordura(resultado, avaliacao);
		CardPeso cardPeso = montarCardPeso(resultado, avaliacao);
		return new ResultadoDto(cardGordura, cardPeso);

	}

	private CardPeso montarCardPeso(ResultadoAvaliacao resultado, AvaliacaoFisica avaliacao) {

		CardPeso cardPeso = new CardPeso();
		// peso
		double peso = avaliacao.getAnamnese().getPeso();
		cardPeso.setPeso(String.valueOf(fmt1dec.format(peso)) + "kg");

		// estado
		cardPeso.setEstado("Acima do peso teste");

		// objetivo
		double metaPeso = avaliacao.getAnamnese().getMetaPeso();

		String objetivo = "";
		if (metaPeso <= peso) {
			double precisaPerder = peso - metaPeso;
			objetivo = "Você precisa perder " + fmt1dec.format(precisaPerder) + "kg";
		} else {
			double pesoGanhar = metaPeso - peso;
			objetivo = "Você precisa ganhar " + fmt1dec.format(pesoGanhar) + "kg";
		}
		cardPeso.setObjetivo(objetivo);

		return cardPeso;
	}

	private CardGordura montarCardGordura(ResultadoAvaliacao resultado, AvaliacaoFisica avaliacao) {
		CardGordura cardGordura = new CardGordura();

		// percentual de gordura
		double bf = resultado.getPercentualGordura();
		String percentualGordura = String.valueOf(fmt.format(bf));
		cardGordura.setPercentualGordura(percentualGordura + "%");

		// percentual de massa magra
		double percentualMM = 100 - bf;

		// Para calcular o peso da gordura corporal do indivíduo, utiliza-se a
		// formula a seguir:
		// Gordura total em quilos = Peso total * Percentual de gordura / 100
		double gorduraTotal = avaliacao.getAnamnese().getPeso() * (resultado.getPercentualGordura() / 100);
		cardGordura.setGorduraTotal(String.valueOf(fmt.format(gorduraTotal)));

		// Para calcular a massa magra de um indivíduo:
		// Massa magra = Peso total – Massa gorda
		double massaMagra = avaliacao.getAnamnese().getPeso() - gorduraTotal;
		cardGordura.setMassaMagra(String.valueOf(fmt.format(massaMagra)));

		// objetivo
		cardGordura.setObjetivo("Sem objetivo ainda");

		// grafico de gordura
		cardGordura.setData(montarArray(bf, percentualMM));

		return cardGordura;
	}

	private String[] montarArray(double... medidas) {

		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("#0.00");

		List<String> lista = new ArrayList<String>();
		for (double m : medidas) {
			String valor = String.valueOf(df.format(m));
			lista.add(valor);
		}
		String[] medidasArray = new String[lista.size()];
		return lista.toArray(medidasArray);
	}


}
