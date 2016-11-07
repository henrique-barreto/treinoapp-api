package com.treinoapp.usuario.validator;

import static org.apache.commons.validator.GenericValidator.isBlankOrNull;
import static org.apache.commons.validator.GenericValidator.isEmail;
import static org.apache.commons.validator.GenericValidator.isInRange;
import static org.apache.commons.validator.GenericValidator.maxLength;
import static org.apache.commons.validator.GenericValidator.minLength;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treinoapp.infra.exceptions.DefaultError;
import com.treinoapp.infra.exceptions.InvalidRequestParamException;
import com.treinoapp.infra.exceptions.RequestConflictException;
import com.treinoapp.usuario.dao.UsuarioRepository;
import com.treinoapp.usuario.model.Usuario;

@Component
public class UsuarioValidator {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioRepository repository;

	private static final int MIN_SIZE_SENHA = 3;
	private static final int MIN_SIZE_NOME = 3;
	private static final int MAX_SIZE_NOME = 45;

	public void validar(Usuario u) {

		List<DefaultError> erros = new ArrayList<DefaultError>();

		if (repository.findByEmail(u.getEmail()) != null) {
			throw new RequestConflictException(new DefaultError("123", "Email ja cadastrado."));
		}

		if (isBlankOrNull(u.getEmail()) || !isEmail(u.getEmail())) {
			erros.add(new DefaultError("123", "Email invalido"));
		}

		if (isBlankOrNull(u.getNome()) || !minLength(u.getNome(), MIN_SIZE_NOME)
				|| !maxLength(u.getNome(), MAX_SIZE_NOME)) {
			erros.add(new DefaultError("123", "Nome invalido"));
		}

		if (isBlankOrNull(u.getSenha()) || !minLength(u.getSenha(), MIN_SIZE_SENHA)) {
			erros.add(new DefaultError("123", "Senha invalida"));
		}

		if (!isInRange(u.getIdade(), 1, 99)) {
			erros.add(new DefaultError("123", "Idade invalida"));
		}

		if (u.getPermissao() == null) {
			erros.add(new DefaultError("123", "Usuario com permissao invalida"));
		}

		if (u.getSexo() == null) {
			erros.add(new DefaultError("123", "Usuario com sexo invalido"));
		}

		verificaErros(erros);

	}

	private void verificaErros(List<DefaultError> erros) {

		if (!erros.isEmpty()) {
			for (DefaultError d : erros) {
				logger.debug(d.getMensagem());
			}
			throw new InvalidRequestParamException(erros);
		}
	}

}