package com.treinoapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.dao.interfaces.AlunoDAO;
import com.treinoapp.model.Aluno;
import com.treinoapp.services.interfaces.AlunoService;

@Service
@Transactional
public class AlunoServiceImpl implements AlunoService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AlunoDAO dao;

	@Override
	public Aluno adicionar(Aluno aluno) {
		logger.debug("adicionar() Adicionando aluno com nome: " + aluno.getNome());
		return dao.adicionar(aluno);
	}

	@Override
	public Aluno atualizar(Aluno aluno) {
		logger.debug("atualizar() Atualizar aluno com id: " + aluno.getId());
		return dao.atualizar(aluno);
	}

	@Override
	public void remover(Long id) {
		logger.debug("remover() remover aluno com id: " + id);
		dao.remover(id);
	}

	@Override
	public Aluno buscarPorId(Long id) {
		logger.debug("buscarPorId() Buscar aluno por id: " + id);
		return dao.buscarPorId(id);
	}

	@Override
	public Aluno buscarPorEmail(String email) {
		logger.debug("buscarPorEmail() Buscar aluno por email: " + email);
		return dao.buscarPorEmail(email);
	}

	@Override
	public List<Aluno> buscarPorNome(String nome) {
		logger.debug("buscarPorNome() Buscar aluno por nome: " + nome);
		return buscarPorNome(nome);
	}

	@Override
	public List<Aluno> buscarPorParteEmail(String email) {
		logger.debug("buscarPorParteEmail() Buscar por parte email: " + email);
		return dao.buscarPorParteEmail(email);
	}

}
