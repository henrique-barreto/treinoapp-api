package com.treinoapp.usuario.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinoapp.usuario.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	
	List<Aluno> findByNomeContaining(String nome);

	List<Aluno> findByEmailContaining(String parteEmail);
}
