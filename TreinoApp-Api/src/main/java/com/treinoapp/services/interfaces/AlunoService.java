package com.treinoapp.services.interfaces;

import java.util.List;

import com.treinoapp.model.Aluno;

public interface AlunoService extends GenericService<Aluno, Long> {

	Aluno buscarPorEmail(String email);

	List<Aluno> buscarPorNome(String nome);

	List<Aluno> buscarPorParteEmail(String email);

}
