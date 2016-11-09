package com.treinoapp.avaliacao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.avaliacao.dao.AvaliacaoRepository;
import com.treinoapp.avaliacao.dto.EstatisticasDto;
import com.treinoapp.avaliacao.model.AvaliacaoFisica;

@Service
@Transactional
public class AvaliacaoEstatisticasService {

	@Autowired
	private AvaliacaoRepository repository;

	public EstatisticasDto pegarEstatisticas(Long id) {

		List<AvaliacaoFisica> avaliacoes = repository.findFirst4ByAlunoId(id);
		EstatisticasDto dto = new EstatisticasDto(avaliacoes);
		return dto;

	}

}
