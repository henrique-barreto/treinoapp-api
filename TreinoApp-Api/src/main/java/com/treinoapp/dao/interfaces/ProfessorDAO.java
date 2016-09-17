package com.treinoapp.dao.interfaces;

import java.util.List;

import com.treinoapp.model.Professor;

public interface ProfessorDAO extends GenericDAO<Professor, Long> {

	Professor buscarPorEmail(String email);

	List<Professor> buscarPorNome(String nome);

	List<Professor> buscarPorParteEmail(String email);
}
