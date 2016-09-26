package com.treinoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.avaliacao.ResultadoAvaliacao;
import com.treinoapp.model.Aluno;
import com.treinoapp.model.AvaliacaoFisica;
import com.treinoapp.model.Professor;
import com.treinoapp.services.interfaces.AlunoService;
import com.treinoapp.services.interfaces.AvaliacaoService;
import com.treinoapp.services.interfaces.ProfessorService;

@RestController
@RequestMapping(value = "/api/v1/avaliacao")
public class AvaliacaoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AvaliacaoService avaliacaoService;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private ProfessorService professorService;

	@RequestMapping(path = "/aluno/{idAluno}/professor/{idProfessor}", method = RequestMethod.POST)
	public AvaliacaoFisica adicionar(@PathVariable Long idAluno, @PathVariable Long idProfessor,
			@RequestBody AvaliacaoFisica avaliacao) {

		logger.debug("adicionar() cadastro de avaliacao fisica - Aluno: " + idAluno + " professor: " + idProfessor);

		Aluno aluno = alunoService.buscarPorId(idAluno);
		Professor professor = professorService.buscarPorId(idProfessor);
		avaliacao.setAluno(aluno);
		avaliacao.setProfessor(professor);

		logger.debug("\n" + avaliacao.getAnamnese().toString());
		logger.debug("\n" + avaliacao.getPerimetria().toString());
		logger.debug("\n" + avaliacao.getDobras().toString());

		AvaliacaoFisica ava = avaliacaoService.adicionar(avaliacao);
		return ava;
	}

	@RequestMapping(path = "/resultado", method = RequestMethod.GET)
	public ResultadoAvaliacao gerarResultadoAvaliacao(@RequestParam Long id) {

		logger.debug("gerarResultadoAvaliacao() Gerando resultado para avaliacao com id: " + id);
		AvaliacaoFisica avaliacaoFisica = avaliacaoService.buscarPorId(id);
		if (avaliacaoFisica != null) {
			return avaliacaoFisica.getResultado();
		}
		return null;

	}

}
