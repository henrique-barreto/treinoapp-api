package com.treinoapp.services.interfaces;

import java.util.List;

import com.treinoapp.model.Usuario;

public interface UsuarioService extends GenericService<Usuario, Long> {

	Usuario buscarPorEmail(String email);

	List<Usuario> buscarPorNome(String nome);

	List<Usuario> buscarPorParteEmail(String email);

}
