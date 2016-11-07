package com.treinoapp.infra.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvalidRequestParamException extends RuntimeException {

	private static final long serialVersionUID = -7680750609859283351L;

	private List<DefaultError> erros = new ArrayList<DefaultError>();

	public InvalidRequestParamException(List<DefaultError> erros) {
		this.erros.addAll(erros);
	}

	public InvalidRequestParamException(DefaultError erro) {
		this.erros.add(erro);
	}

	public List<DefaultError> getErros() {
		return Collections.unmodifiableList(erros);
	}

}
