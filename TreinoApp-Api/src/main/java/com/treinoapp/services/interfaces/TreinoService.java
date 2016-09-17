package com.treinoapp.services.interfaces;

import java.util.List;

import com.treinoapp.model.Treino;

public interface TreinoService extends GenericService<Treino, Long> {

	Treino buscarTreinoAtivo(Long idAluno);

	List<Treino> listarTreinos(Long idAluno);
	
	List<Treino> listarTreinosDoProfessor(Long idProfessor);

}
