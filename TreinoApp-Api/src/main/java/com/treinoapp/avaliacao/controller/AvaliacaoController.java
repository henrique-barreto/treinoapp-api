package com.treinoapp.avaliacao.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.treinoapp.avaliacao.dto.EstatisticasDto;
import com.treinoapp.avaliacao.dto.ResultadoDto;
import com.treinoapp.avaliacao.model.AvaliacaoFisica;
import com.treinoapp.avaliacao.service.AvaliacaoEstatisticasService;
import com.treinoapp.avaliacao.service.AvaliacaoResultadoService;
import com.treinoapp.avaliacao.service.AvaliacaoService;

@RestController
@RequestMapping(value = "/api/v1/avaliacoes")
public class AvaliacaoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AvaliacaoService avaliacaoService;

	@Autowired
	private AvaliacaoResultadoService resultadoService;

	@Autowired
	private AvaliacaoEstatisticasService estatisticasService;

	@RequestMapping(path = "/aluno/{idAluno}/professor/{idProfessor}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public AvaliacaoFisica adicionar(@PathVariable Long idAluno, @PathVariable Long idProfessor,
			@RequestBody AvaliacaoFisica avaliacao) {

		logger.debug("adicionar() cadastro de avaliacao fisica - Aluno: " + idAluno + " professor: " + idProfessor);
		logger.debug("\n" + avaliacao.getAnamnese().toString());
		logger.debug("\n" + avaliacao.getPerimetria().toString());
		logger.debug("\n" + avaliacao.getDobras().toString());

		return avaliacaoService.salvar(avaliacao, idAluno, idProfessor);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public AvaliacaoFisica atualizar(@RequestBody AvaliacaoFisica avaliacao) {
		return avaliacaoService.atualizar(avaliacao);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void remover(@PathVariable(name = "id", required = true) Long id) {
		avaliacaoService.remover(id);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public AvaliacaoFisica buscarPorId(@PathVariable(name = "id", required = true) Long id) {
		return avaliacaoService.buscarPorId(id);
	}

	@RequestMapping(path = "/aluno/{idAluno}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<AvaliacaoFisica> listarAvaliaoesDoAluno(@PathVariable(name = "idAluno", required = true) Long idAluno) {
		return avaliacaoService.listarAvaliaoesDoAluno(idAluno);
	}

	@RequestMapping(path = "/resultado/{idAvaliacao}", method = RequestMethod.GET)
	public ResultadoDto gerarResultado(@PathVariable(required = true) Long idAvaliacao) {
		logger.debug("gerarResultadoAvaliacao() Gerando resultado para avaliacao com id: " + idAvaliacao);
		return resultadoService.pegarResultado(idAvaliacao);
	}

	@RequestMapping(path = "/estatisticas/{idAluno}", method = RequestMethod.GET)
	public EstatisticasDto gerarEstatisticas(@PathVariable(required = true) Long idAluno) {
		logger.debug("gerarEstatisticas() Gerando estatiscas para aluno: " + idAluno);
		return estatisticasService.pegarEstatisticas(idAluno);
	}

}
