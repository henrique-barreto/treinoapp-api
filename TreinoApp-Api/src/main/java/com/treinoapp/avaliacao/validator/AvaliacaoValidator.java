package com.treinoapp.avaliacao.validator;

import com.treinoapp.avaliacao.model.Anamnese;
import com.treinoapp.avaliacao.model.AvaliacaoFisica;
import com.treinoapp.avaliacao.model.Dobras;
import com.treinoapp.avaliacao.model.Perimetria;
import com.treinoapp.infra.exceptions.DefaultError;
import com.treinoapp.infra.exceptions.InvalidRequestParamException;

import static org.apache.commons.validator.GenericValidator.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AvaliacaoValidator {

	public void validar(AvaliacaoFisica avaliacao) {
		validarAvaliacao(avaliacao);
		validarAnamnese(avaliacao.getAnamnese());
		validarDobras(avaliacao.getDobras());
		validarPerimetria(avaliacao.getPerimetria());
	}

	private void validarPerimetria(Perimetria p) {
		
		List<DefaultError> erros = new ArrayList<DefaultError>();
		
		if (!isInRange(p.getOmbro(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria ombro invalida"));
		}
		
		if (!isInRange(p.getTorax(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria torax invalida"));
		}
		
		if (!isInRange(p.getAbdominal(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria abdominal invalida"));
		}
		
		if (!isInRange(p.getGluteo(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria gluteo invalida"));
		}
		
		if (!isInRange(p.getCoxaSuperior(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria coxaSuperior invalida"));
		}
		
		if (!isInRange(p.getCoxaMedia(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria coxaMedia invalida"));
		}
		
		if (!isInRange(p.getCoxaInferior(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria coxaInferior invalida"));
		}
		
		if (!isInRange(p.getBicepsContraido(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria bicepsContraido invalida"));
		}
		
		if (!isInRange(p.getBiceps(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria biceps invalida"));
		}
		
		if (!isInRange(p.getAntebraco(), 1, 999)) {
			erros.add(new DefaultError("123", "Perimetria antebraco invalida"));
		}
		
		verificaErros(erros);
		
	}

	private void validarDobras(Dobras dobras) {
		
		List<DefaultError> erros = new ArrayList<DefaultError>();
		
		if (!isInRange(dobras.getAbdominal(), 1, 999)) {
			erros.add(new DefaultError("123", "Dobra abdominal invalida"));
		}
		
		if (!isInRange(dobras.getAxilarMedia(), 1, 999)) {
			erros.add(new DefaultError("123", "Dobra axilar media invalida"));
		}
		
		if (!isInRange(dobras.getTriceps(), 1, 999)) {
			erros.add(new DefaultError("123", "Dobra triceps invalida"));
		}
		
		if (!isInRange(dobras.getPeitoral(), 1, 999)) {
			erros.add(new DefaultError("123", "Dobra peitoral invalida"));
		}
		
		if (!isInRange(dobras.getFemuralMedio(), 1, 999)) {
			erros.add(new DefaultError("123", "Dobra femural media invalida"));
		}
		
		if (!isInRange(dobras.getSuprailiaca(), 1, 999)) {
			erros.add(new DefaultError("123", "Dobra suprailiaca invalida"));
		}
		
		if (!isInRange(dobras.getSubescapular(), 1, 999)) {
			erros.add(new DefaultError("123", "Dobra subescapular invalida"));
		}
		
		verificaErros(erros);
		
	}

	private void validarAnamnese(Anamnese anamnese) {
		
		List<DefaultError> erros = new ArrayList<DefaultError>();
		
		if (!isInRange(anamnese.getAltura(), 50, 250)) {
			erros.add(new DefaultError("123", "Altura invalida"));
		}
		
		if (!isInRange(anamnese.getPeso(), 25, 350)) {
			erros.add(new DefaultError("123", "Peso invalido"));
		}
		
		if (isBlankOrNull(anamnese.getObjetivo())) {
			erros.add(new DefaultError("123", "Objetivo invalido"));
		}
		
		if (!isInRange(anamnese.getMetaPeso(), 25, 350)) {
			erros.add(new DefaultError("123", "Meta peso invalido."));
		}
		
		if (!isInRange(anamnese.getMetaBF(), 3, 90)) {
			erros.add(new DefaultError("123", "Meta BF invalido."));
		}
		
		verificaErros(erros);
		
	}

	private void validarAvaliacao(AvaliacaoFisica avaliacao) {
		//TODO Avaliacao validacao
	}
	
	private void verificaErros(List<DefaultError> erros) {
		if (!erros.isEmpty())
			throw new InvalidRequestParamException(erros);
	}

}
