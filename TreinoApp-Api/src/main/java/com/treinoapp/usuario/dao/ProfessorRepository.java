package com.treinoapp.usuario.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinoapp.usuario.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	List<Professor> findByNomeContaining(String nome);

	List<Professor> findByEmailContaining(String parteEmail);
	
}
