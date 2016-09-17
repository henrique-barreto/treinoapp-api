package com.treinoapp.dao.interfaces;

import java.util.List;

import com.treinoapp.model.Aluno;

public interface AlunoDAO extends GenericDAO<Aluno, Long> {

	Aluno buscarPorEmail(String email);

	List<Aluno> buscarPorNome(String nome);

	List<Aluno> buscarPorParteEmail(String email);

}
