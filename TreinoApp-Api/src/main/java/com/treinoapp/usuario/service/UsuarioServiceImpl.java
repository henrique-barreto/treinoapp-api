package com.treinoapp.usuario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.infra.exceptions.DefaultError;
import com.treinoapp.infra.exceptions.MyEntityNotFoundException;
import com.treinoapp.usuario.dao.UsuarioRepository;
import com.treinoapp.usuario.model.Usuario;
import com.treinoapp.usuario.service.interfaces.UsuarioService;
import com.treinoapp.usuario.validator.UsuarioValidator;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioValidator validator;

	@Override
	public void salvar(Usuario usuario) {
		validator.validar(usuario);
		logger.debug("salvar() Salvar usuario: " + usuario.getNome());
		repository.save(usuario);
	}

	@Override
	public void atualizar(Long id, Usuario dto) {
		logger.debug("atualizar() Atualizar usuario: " + dto.getNome());

		Usuario usuario = repository.findOne(id);
		if (usuario == null)
			throw new MyEntityNotFoundException(new DefaultError("123", "Usuario com id: " + id + " nao encontrado."));

		validator.validar(dto);
		usuario.setEmail(dto.getEmail());
		usuario.setIdade(dto.getIdade());
		usuario.setNome(dto.getNome());
		usuario.setSenha(dto.getSenha());
		usuario.setSexo(dto.getSexo());
		repository.save(usuario);
	}

	@Override
	public void remover(Long id) {
		if (!repository.exists(id)) {
			throw new MyEntityNotFoundException(
					new DefaultError("123", "Entidade Usuario com id: " + id + " nao existe."));
		}
		repository.delete(id);
	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		logger.debug("Buncando usuarios por nome: " + nome);
		return repository.findByNomeContaining(nome);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		logger.debug("Buncando usuario por email: " + email);
		return repository.findByEmail(email);
	}

	@Override
	public List<Usuario> buscarPorEmailContendo(String emailParte) {
		logger.debug("Buncando usuarios por parte de email: " + emailParte);
		return repository.findByEmailContaining(emailParte);
	}

}
