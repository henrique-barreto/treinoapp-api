package com.treinoapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.dao.UsuarioDAO;
import com.treinoapp.model.Usuario;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO dao;

	@Override
	public void adicionar(Usuario usuario) {
		System.out.println("Adicionando usuario...");
		dao.adicionar(usuario);
	}

	@Override
	public void atualizar(Usuario usuario) {
		dao.atualizar(usuario);
	}

	@Override
	public void remover(Long id) {
		dao.remover(id);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		return dao.buscarPorNome(nome);
	}

}
