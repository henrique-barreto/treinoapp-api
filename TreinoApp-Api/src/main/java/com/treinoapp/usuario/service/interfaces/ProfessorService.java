package com.treinoapp.usuario.service.interfaces;

import java.util.List;

import com.treinoapp.usuario.model.Professor;

public interface ProfessorService {

	Professor buscarPorId(Long id);

	List<Professor> buscarPorNome(String nome);

	List<Professor> buscarPorEmailContendo(String parteEmail);

}
