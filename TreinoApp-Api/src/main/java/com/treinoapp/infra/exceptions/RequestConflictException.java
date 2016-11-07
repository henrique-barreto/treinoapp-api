package com.treinoapp.infra.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RequestConflictException extends RuntimeException {

	private static final long serialVersionUID = -2677791216143940177L;
	
	private List<DefaultError> erros = new ArrayList<DefaultError>();

	public RequestConflictException(List<DefaultError> erros) {
		this.erros.addAll(erros);
	}

	public RequestConflictException(DefaultError erro) {
		this.erros.add(erro);
	}

	public List<DefaultError> getErros() {
		return Collections.unmodifiableList(erros);
	}
	
}
