package com.treinoapp.avaliacao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinoapp.avaliacao.dao.AvaliacaoRepository;
import com.treinoapp.avaliacao.model.AvaliacaoFisica;
import com.treinoapp.avaliacao.validator.AvaliacaoValidator;
import com.treinoapp.infra.exceptions.DefaultError;
import com.treinoapp.infra.exceptions.InvalidRequestParamException;
import com.treinoapp.infra.exceptions.MyEntityNotFoundException;
import com.treinoapp.usuario.dao.AlunoRepository;
import com.treinoapp.usuario.dao.ProfessorRepository;
import com.treinoapp.usuario.model.Aluno;
import com.treinoapp.usuario.model.Professor;

@Service
@Transactional
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository repository;

	@Autowired
	private AvaliacaoValidator validator;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;

	public AvaliacaoFisica salvar(AvaliacaoFisica avaliacao, Long idAluno, Long idProfessor) {
		
		validator.validar(avaliacao);
		
		Professor professor = professorRepository.findOne(idProfessor);
		if (professor == null) {
			throw new MyEntityNotFoundException(new DefaultError("123", "Professor com id " + idProfessor + " nao encontrado."));
		}
		
		Aluno aluno = alunoRepository.findOne(idAluno);
		if (aluno == null) {
			throw new MyEntityNotFoundException(new DefaultError("123", "Aluno com id " + idAluno + " nao encontrado."));
		}
		
		avaliacao.setProfessor(professor);
		avaliacao.setAluno(aluno);
		
		return repository.saveAndFlush(avaliacao);
	}

	public AvaliacaoFisica atualizar(AvaliacaoFisica avaliacao) {
		if (avaliacao.getId() == null)
			throw new InvalidRequestParamException(new DefaultError("123", "Id da avaliacao invalido"));
		return repository.save(avaliacao);
	}

	public void remover(Long id) {
		repository.delete(id);
	}

	public AvaliacaoFisica buscarPorId(Long id) {
		
		return null;
	}

	public List<AvaliacaoFisica> listarAvaliaoesDoAluno(Long idAluno) {
		return repository.findByAlunoId(idAluno);
	}

}
