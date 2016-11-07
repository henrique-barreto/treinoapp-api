package com.treinoapp.usuario.service.interfaces;

import java.util.List;

import com.treinoapp.usuario.model.Aluno;

public interface AlunoService {

	Aluno buscarPorId(Long id);

	List<Aluno> buscarPorNome(String nome);

	List<Aluno> buscarPorEmailContendo(String parteEmail);

}
