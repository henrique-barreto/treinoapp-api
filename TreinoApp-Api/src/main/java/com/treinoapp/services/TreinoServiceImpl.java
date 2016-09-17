package com.treinoapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.dao.interfaces.TreinoDAO;
import com.treinoapp.model.Treino;
import com.treinoapp.services.interfaces.TreinoService;

@Service
@Transactional
public class TreinoServiceImpl implements TreinoService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TreinoDAO dao;

	@Override
	public Treino adicionar(Treino treino) {
		logger.debug("adicionar() Adicionando treino");
		return dao.adicionar(treino);
	}

	@Override
	public Treino atualizar(Treino treino) {
		logger.debug("atualizar() Atualizando treino");
		return dao.atualizar(treino);
	}

	@Override
	public void remover(Long id) {
		logger.debug("remover() Removendo treino: " + id);
		dao.remover(id);
	}

	@Override
	public Treino buscarPorId(Long id) {
		logger.debug("buscarPorId() Buscando treino por id: " + id);
		return dao.buscarPorId(id);
	}

	@Override
	public Treino buscarTreinoAtivo(Long idAluno) {
		logger.debug("buscarTreinoAtivo() Buscando treino ativo do aluno: " + idAluno);
		return dao.buscarTreinoAtivo(idAluno);
	}

	@Override
	public List<Treino> listarTreinos(Long idAluno) {
		logger.debug("listarTreinos() Listando treinos do aluno: " + idAluno);
		return dao.listarTreinos(idAluno);
	}

	@Override
	public List<Treino> listarTreinosDoProfessor(Long idProfessor) {
		logger.debug("listarTreinos() Listando treinos do professor:" + idProfessor);
		return dao.listarTreinosDoProfessor(idProfessor);
	}

}
