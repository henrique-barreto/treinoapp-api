package com.treinoapp.usuario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.infra.exceptions.DefaultError;
import com.treinoapp.infra.exceptions.MyEntityNotFoundException;
import com.treinoapp.usuario.dao.ProfessorRepository;
import com.treinoapp.usuario.model.Professor;
import com.treinoapp.usuario.service.interfaces.ProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProfessorRepository repository;

	@Override
	public Professor buscarPorId(Long id) {
		logger.debug("buscarPorId() Buscar professor por id: " + id);

		Professor professor = repository.findOne(id);
		if (professor == null)
			throw new MyEntityNotFoundException(new DefaultError("123", "Professor com id: " + id + " nao encontrado."));

		return professor;
	}

	@Override
	public List<Professor> buscarPorNome(String nome) {
		return repository.findByNomeContaining(nome);
	}

	@Override
	public List<Professor> buscarPorEmailContendo(String parteEmail) {
		return repository.findByEmailContaining(parteEmail);
	}

}
