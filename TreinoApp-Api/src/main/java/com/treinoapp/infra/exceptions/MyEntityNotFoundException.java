package com.treinoapp.infra.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyEntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3165219363617571491L;
	
	private List<DefaultError> erros = new ArrayList<DefaultError>();

	public MyEntityNotFoundException(List<DefaultError> erros) {
		this.erros.addAll(erros);
	}

	public MyEntityNotFoundException(DefaultError erro) {
		this.erros.add(erro);
	}

	public List<DefaultError> getErros() {
		return Collections.unmodifiableList(erros);
	}
}
