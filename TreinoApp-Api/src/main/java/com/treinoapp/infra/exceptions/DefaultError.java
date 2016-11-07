package com.treinoapp.infra.exceptions;

public class DefaultError {

	private String cod;
	private String mensagem;

	public DefaultError(String cod, String mensagem) {
		super();
		this.cod = cod;
		this.mensagem = mensagem;
	}


	public String getCod() {
		return cod;
	}


	public String getMensagem() {
		return mensagem;
	}


}
