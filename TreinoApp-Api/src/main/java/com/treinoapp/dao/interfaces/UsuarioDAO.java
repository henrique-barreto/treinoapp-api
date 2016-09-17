package com.treinoapp.dao.interfaces;

import java.util.List;

import com.treinoapp.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Long> {

	Usuario buscarPorEmail(String email);

	List<Usuario> buscarPorNome(String nome);

	List<Usuario> buscarPorParteEmail(String email);
}
