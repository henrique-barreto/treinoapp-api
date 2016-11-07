package com.treinoapp.usuario.service.interfaces;

import java.util.List;

import com.treinoapp.usuario.model.Usuario;

public interface UsuarioService {

	void salvar(Usuario usuario);

	void atualizar(Long id, Usuario dto);

	void remover(Long id);

	List<Usuario> buscarPorNome(String nome);

	Usuario buscarPorEmail(String email);

	List<Usuario> buscarPorEmailContendo(String emailParte);
	
}
