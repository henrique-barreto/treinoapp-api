package com.treinoapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.dao.interfaces.ProfessorDAO;
import com.treinoapp.model.Professor;
import com.treinoapp.services.interfaces.ProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProfessorDAO dao;

	@Override
	public Professor adicionar(Professor professor) {
		logger.debug("adicionar() Adicionar professor...");
		return dao.adicionar(professor);
	}

	@Override
	public Professor atualizar(Professor professor) {
		logger.debug("atualizar() atualizar professor...");
		return dao.atualizar(professor);
	}

	@Override
	public void remover(Long id) {
		logger.debug("remover() remover professor: " + id);
		dao.remover(id);
	}

	@Override
	public Professor buscarPorId(Long id) {
		logger.debug("buscarPorId() buscar professor por id: " + id);
		return dao.buscarPorId(id);
	}

	@Override
	public Professor buscarPorEmail(String email) {
		logger.debug("buscarPorEmail() buscar professor por email: " + email);
		return dao.buscarPorEmail(email);
	}

	@Override
	public List<Professor> buscarPorNome(String nome) {
		logger.debug("buscarPorNome() buscar professor por nome: " + nome);
		return dao.buscarPorNome(nome);
	}

	@Override
	public List<Professor> buscarPorParteEmail(String email) {
		logger.debug("buscarPorParteEmail() buscar professor por parte email: " + email);
		return dao.buscarPorParteEmail(email);
	}

}
