package com.treinoapp.usuario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.infra.exceptions.DefaultError;
import com.treinoapp.infra.exceptions.MyEntityNotFoundException;
import com.treinoapp.usuario.dao.AlunoRepository;
import com.treinoapp.usuario.model.Aluno;
import com.treinoapp.usuario.service.interfaces.AlunoService;

@Service
@Transactional
public class AlunoServiceImpl implements AlunoService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AlunoRepository repository;

	@Override
	public Aluno buscarPorId(Long id) {
		logger.debug("buscarPorId() Buscar aluno por id: " + id);

		Aluno aluno = repository.findOne(id);
		if (aluno == null)
			throw new MyEntityNotFoundException(new DefaultError("123", "Aluno com id: " + id + " nao encontrado."));

		return aluno;
	}

	@Override
	public List<Aluno> buscarPorNome(String nome) {
		return repository.findByNomeContaining(nome);
	}

	@Override
	public List<Aluno> buscarPorEmailContendo(String parteEmail) {
		return repository.findByEmailContaining(parteEmail);
	}

}
