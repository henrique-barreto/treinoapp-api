package com.treinoapp.avaliacao.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinoapp.avaliacao.model.AvaliacaoFisica;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoFisica, Long> {

	List<AvaliacaoFisica> findByAlunoId(Long idAluno);
	
	List<AvaliacaoFisica> findFirst4ByAlunoId(Long idAluno);

}
