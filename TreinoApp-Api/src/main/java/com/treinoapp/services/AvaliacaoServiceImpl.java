package com.treinoapp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.dao.interfaces.AvaliacaoFisicaDAO;
import com.treinoapp.model.AvaliacaoFisica;
import com.treinoapp.services.interfaces.AvaliacaoService;

@Service
@Transactional
public class AvaliacaoServiceImpl implements AvaliacaoService{

	@Autowired
	private AvaliacaoFisicaDAO dao;
	
	@Override
	public AvaliacaoFisica adicionar(AvaliacaoFisica avaliacao) {
		return dao.adicionar(avaliacao);
	}

	@Override
	public AvaliacaoFisica atualizar(AvaliacaoFisica avaliacao) {
		return atualizar(avaliacao);
	}

	@Override
	public void remover(Long idAvaliacao) {
		dao.remover(idAvaliacao);
	}

	@Override
	public AvaliacaoFisica buscarPorId(Long idAvaliacao) {
		return dao.buscarPorId(idAvaliacao);
	}

}
