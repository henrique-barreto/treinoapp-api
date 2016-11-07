package com.treinoapp.usuario.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinoapp.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
	
	List<Usuario> findByNomeContaining(String nome);

	List<Usuario> findByEmailContaining(String email);
	
}
