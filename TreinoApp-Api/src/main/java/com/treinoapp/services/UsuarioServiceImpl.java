package com.treinoapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.dao.interfaces.UsuarioDAO;
import com.treinoapp.model.Usuario;
import com.treinoapp.services.interfaces.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioDAO dao;

	@Override
	public Usuario adicionar(Usuario usuario) {
		logger.debug("adicionar() Adicionando usuario: " + usuario.getNome());
		return dao.adicionar(usuario);
	}

	@Override
	public Usuario atualizar(Usuario usuario) {
		logger.debug("atualizar() Atualizando usuario: " + usuario.getId());
		return dao.atualizar(usuario);
	}

	@Override
	public void remover(Long id) {
		logger.debug("remover() Removendo usuario: " + id);
		dao.remover(id);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		logger.debug("buscarPorId() Buscando usuario por id: " + id);
		return dao.buscarPorId(id);
	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		logger.debug("buscarPorNome() Buscando usuario por nome: " + nome);
		return dao.buscarPorNome(nome);
	}

	@Override
	public List<Usuario> buscarPorParteEmail(String email) {
		logger.debug("buscarPorParteEmail() Buscando usuario por pate email: " + email);
		return dao.buscarPorParteEmail(email);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		logger.debug("buscarPorEmail() Buscando usuario por email: " + email);
		return dao.buscarPorEmail(email);
	}

}
