package com.treinoapp.dao.interfaces;

import java.util.List;

import com.treinoapp.model.Treino;

public interface TreinoDAO extends GenericDAO<Treino, Long> {
	
	Treino buscarTreinoAtivo(Long idAluno);

	List<Treino> listarTreinos(Long idAluno);
	
	List<Treino> listarTreinosDoProfessor(Long idProfessor);

}
