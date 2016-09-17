package com.treinoapp.services.interfaces;

import java.util.List;

import com.treinoapp.model.Professor;

public interface ProfessorService {

	Professor adicionar(Professor professor);

	Professor atualizar(Professor professor);

	void remover(Long id);

	Professor buscarPorId(Long id);

	Professor buscarPorEmail(String email);

	List<Professor> buscarPorNome(String nome);

	List<Professor> buscarPorParteEmail(String email);

}
