package com.treinoapp.services;

import java.util.List;

import com.treinoapp.model.Usuario;

public interface UsuarioService {

	void adicionar(Usuario usuario);
	void atualizar(Usuario usuario);
	void remover(Long id);
	Usuario buscarPorId(Long id);
	Usuario buscarPorEmail(String email);
	
	List<Usuario> buscarPorNome(String nome);
	List<Usuario> buscarPorParteEmail(String email);
	
}
